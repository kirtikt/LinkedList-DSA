import java.util.Stack;

public class queuestack {
    
    Stack<Integer> a1 = new Stack<>();
    Stack<Integer> a2 = new Stack<>();

    void add(int e){
        a1.push(e);

    }

    int delete(){
        if(a2.isEmpty()){
            if(a1.isEmpty())
            {
                System.out.println("Both Stacks are empty");
            }
        
        while (!a1.isEmpty()) {
                a2.push(a1.pop());
            }
        } 
        return a2.pop();

    }

    int peek(){
        if(a2.isEmpty()){
            if(a1.isEmpty())
            {
                System.out.println("Both Stacks are empty");
            }
        
        while (!a1.isEmpty()) {
                a2.push(a1.pop());
            }
        } 
        return a2.peek();

    }

    boolean isEmpty(){
        return a1.isEmpty() && a2.isEmpty();
    }

    // void printqueue(){
    //     System.out.println(a1);
    // }


    public static void main(String[] args) {
        queuestack q = new queuestack();

        q.add(20);
        q.add(30);
        q.add(40);

        //System.out.println("Element stored are:", q.printqueue());
        System.out.println("Element at top is:"+ q.peek());

        System.out.println("Element at top is:"+ q.delete());
        System.out.println("Element at top is:"+ q.peek());
        System.out.println("Element at top is:"+ q.isEmpty());
        



    }
    

    
}
