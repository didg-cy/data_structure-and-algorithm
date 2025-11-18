package interview_questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Order{
    private String orderID;
    private String address;
    private int estimatedTime;
    public Order(String orderID, String address, int estimatedTime) {
        this.orderID = orderID;
        this.address = address;
        this.estimatedTime = estimatedTime;
    }

    public String getOrderID() {
        return orderID;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }
}

class Rider implements Runnable{
    int riderID;
    BlockingQueue<Order> orderQueue;
    volatile String riderStatus = "空闲";
    Boolean running = true;

    public Rider(int riderID, BlockingQueue orderQueue){
        this.riderID = riderID;
        this.orderQueue = orderQueue;
    }

    public int getRiderID(){
        return riderID;
    }

    public String getRiderStatus(){
        return riderStatus;
    }

    public void run(){
        while(running){
            try {
                //队列为空则线程阻塞 1 s，之后返回 null，执行接下来的逻辑，之后进入下一个循环这样子
                Order order = orderQueue.poll(1, TimeUnit.SECONDS);
                if (order != null) {
                    System.out.println("订单" + order.getOrderID() + "分配给骑手" + riderID + "预计配送时间" + order.getEstimatedTime() * 1.1 + "分钟");
                    riderStatus = "配送中";
                    printRiderStatus();
                    Thread.sleep(1000);
                    riderStatus = "空闲";
                    printRiderStatus();
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printRiderStatus(){
        List<Rider> riders = DeliverySystem.riders;
        if(riders.size() > 0){
            Rider rider_1 = riders.get(0);
            Rider rider_2 = riders.get(1);
            Rider rider_3 = riders.get(2);
            System.out.println("骑手状态：" + rider_1.getRiderID() + "-" + rider_1.getRiderStatus()+"，"
                    + rider_2.getRiderID() + "-" + rider_2.getRiderStatus()+"，"
                    + rider_3.getRiderID() + "-" + rider_3.getRiderStatus());
        }
        else{
            System.out.println("骑手列表为空,请排查");
        }
    }
}

public class DeliverySystem {

    public static List<Rider> riders = new ArrayList<>();

    public static void main(String[] args) {

        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

        //创建任务（线程）并启动线程
        for(int i=0; i<3; i++){
            Rider rider = new Rider(i,orderQueue);
            riders.add(rider);
            Thread thread = new Thread(rider);
            thread.start();
        }

        Scanner scanner = new Scanner(System.in);
        //程序持续接收新订单
        while(true){
            String input = scanner.nextLine();
            //输入 end 后停止接收新订单
            if("end".equalsIgnoreCase(input)){
                //轮询订单队列的线程
                new Thread(() -> {
                    //轮询订单队列
                    try {
                        while (true) {
                            if (orderQueue.isEmpty()) {
                                for (Rider r : riders) {
                                    r.running = false;
                                }
                                //使用 .take() 时，队列为空时线程始终处于阻塞状态，是没办法修改的，故改成 .poll()；
                                System.out.println("订单队列已清空，系统将在骑手配送完成手上订单后关闭");
                                break;
                            }
                            Thread.sleep(1000);
                        }
                    }catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
                break;
            }
            String[] parts = input.split("-");
            if(parts.length != 3){
                System.out.println("输入格式错误，请重新输入");
                continue;
            }
            Order order = new Order(parts[0], parts[1], Integer.parseInt(parts[2]));
            orderQueue.offer(order);
        }
    }
}
