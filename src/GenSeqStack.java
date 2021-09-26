public class GenSeqStack<E>{
    final int DEF_SIZE = 10;
    E[] A = null;
    int size;
    int n;
    @SuppressWarnings("unchecked")
    public GenSeqStack(){
        size = DEF_SIZE;
        A = (E[])new Object[size];
        n = 0;
    }

    @SuppressWarnings("unchecked")
    public GenSeqStack(int s){
        if(s < 2 || s > 10000)
            size = DEF_SIZE;
        else
            size = s;
        A = (E[])new Object[size];
        n = 0;
    }

    public Status enStack(E value,getType<E> oldV){
        if(n==size){
            System.out.println("栈已满，无法入栈");
            return null;
        }
        A[n] = value;
        oldV.value = value;
        n++;
        return Status.OK;
    }

    public Status deStack(getType<E> oldV){
        n--;
        if(n < 0){
            n=0;
            System.out.print("栈已空，无法出栈");
            return null;
        }

        if(n>=0){
            oldV.value = A[n];
            A[n] = null;
        }
        return Status.OK;
    }

    public Status getStackHead(getType<E> oldV){
        int index = n;
        index--;
        if(n>0){
            oldV.value = A[index];
        }else{
            System.out.println("栈空无法获得栈头");
            return null;
        }
        return Status.OK;
    }

    public Boolean isEmpty(){
        return n<0;
    }


    public int size(){
        return n;
    }

    public void show(){
        for(int i =0; i < n; i++){
            System.out.print(A[i] + "  ");
        }
        System.out.println();
    }
}
