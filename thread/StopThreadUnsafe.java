package thread;

public class StopThreadUnsafe {
    public static User u = new User();
    public static class User{
        private int id;
        private String name;


        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public int getId() {
            return id;
        }


        public User(){
            id = 0;
            name = "0";
        }
        @Override
        public String toString(){
            return "User [id=" + id + ",name=" + name +"]";
        }

    }

    private static class ChangeObjectThread extends Thread{
        volatile boolean stopme = false;
        public void stopMe(){ // 正确的退出方式
            stopme = true;
        }

        @Override
        public void run(){
            while(true){
                if(stopme){
                    System.out.println("exit by stop me");
                    break;
                }
                synchronized (u){
                    int v = (int)(System.currentTimeMillis()/1000);
                    u.setId(v);
                    //oh, do sth. else
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    u.setName(String.valueOf(v));
                }
                Thread.yield();
            }
        }
    }
    public static class ReadObjectThread extends Thread{
        @Override
        public void run(){
            while (true){
                synchronized (u){
                    if(u.getId() != Integer.parseInt(u.getName())){
                        System.out.println(u.toString());
                    }
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        new ReadObjectThread().start();
        while(true){
            Thread t = new ChangeObjectThread();
            t.start();
            Thread.sleep(150);
//            t.stop();
            ((ChangeObjectThread) t).stopMe();
        }
    }
}
