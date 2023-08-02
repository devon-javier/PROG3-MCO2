public class Money implements Cloneable{

    private int peso1, peso5, peso10, peso20, peso50, peso100,
                peso200, peso500, peso1000;
                
    public Money()  {
        this.peso1 = 0;
        this.peso5 = 0;
        this.peso10 = 0;
        this.peso20 = 0; 
        this.peso50 = 0;
        this.peso100 = 0;
        this.peso200 = 0;
        this.peso500 = 0;
        this.peso1000 = 0;
    }

    public void addPeso1(int peso1) {
        this.peso1 += peso1;
    }
    public void addPeso5(int peso5) {
        this.peso5 += peso5;
    }
    public void addPeso10(int peso10) {
        this.peso10 += peso10;
    }
    public void addPeso20(int peso20) {
        this.peso20 += peso20;
    }
    public void addPeso50(int peso50) {
        this.peso50 += peso50;
    }
    public void addPeso100(int peso100) {
        this.peso100 += peso100;
    }
    public void addPeso200(int peso200) {
        this.peso200 += peso200;
    }
    public void addPeso500(int peso500) {
        this.peso500 += peso500;
    }
    public void addPeso1000(int peso1000) {
        this.peso1000 += peso1000;
    }

    public void reducePeso1(int peso1) {
        this.peso1 -= peso1;
    }
    public void reducePeso5(int peso5) {
        this.peso5 -= peso5;
    }
    public void reducePeso10(int peso10) {
        this.peso10 -= peso10;
    }
    public void reducePeso20(int peso20) {
        this.peso20 -= peso20;
    }
    public void reducePeso50(int peso50) {
        this.peso50 -= peso50;
    }
    public void reducePeso100(int peso100) {
        this.peso100 -= peso100;
    }
    public void reducePeso200(int peso200) {
        this.peso200 -= peso200;
    }
    public void reducePeso500(int peso500) {
        this.peso500 -= peso500;
    }
    public void reducePeso1000(int peso1000) {
        this.peso1000 -= peso1000;
    }

    public int getPeso1() {
        return this.peso1;
    }
    public int getPeso5() {
        return this.peso5;
    }
    public int getPeso10() {
        return this.peso10;
    }
    public int getPeso20() {
        return this.peso20;
    }
    public int getPeso50() {
        return this.peso50;
    }
    public int getPeso100() {
        return this.peso100;
    }
    public int getPeso200() {
        return this.peso200;
    }
    public int getPeso500() {
        return this.peso500;
    }
    public int getPeso1000() {
        return this.peso1000;
    }

    public void displayMoney()  {
        System.out.println("\n1 Peso - " + this.peso1);
        System.out.println("5 Pesos - " + this.peso5);
        System.out.println("10 Pesos - " + this.peso10);
        System.out.println("20 Pesos - " + this.peso20);
        System.out.println("50 Pesos - " + this.peso50);
        System.out.println("100 Pesos - " + this.peso100);
        System.out.println("200 Pesos - " + this.peso200);
        System.out.println("500 Pesos - " + this.peso500);
        System.out.println("1000 Pesos - " + this.peso1000);

        System.out.println("\nTotal : " + computeTotal());

    }

    public double computeTotal() {
        double total;

        total = (this.peso1 * 1) + (this.peso5 * 5) + (this.peso10 * 10) + (this.peso20 * 20) + (this.peso50 * 50) + (this.peso100 * 100) 
                + (this.peso200 * 200) + (this.peso500 * 500) + (this.peso1000 * 1000);
        
        return total;
    }

    /* 

    -- CAN BE REMOVED BECAUSE VIEW WILL IMPLEMENT BUTTONS TO IMMEDIATELY ADD TO MONEY OBJECT

    SLAY
    
    public int addBill(int bill) {
        int returnType = 1;

        switch(bill)    {
            case -1: returnType = -1; break;
            case 0: returnType = 0; break;
            case 1: this.peso1++; break;
            case 5: this.peso5++; break;
            case 10: this.peso10++; break;
            case 20: this.peso20++; break;
            case 50: this.peso50++; break;
            case 100: this.peso100++; break;
            case 200: this.peso200++; break;
            case 500: this.peso500++; break;
            case 1000: this.peso1000++; break;
            default: System.out.println("Wrong Input!");

        }

        return returnType;

    }

    public int removeBill(int bill) {
        int returnType = 1;

        switch(bill)    {
            case -1: returnType = -1; break;
            case 0: returnType = 0; break;
            case 1: this.peso1--; break;
            case 5: this.peso5--; break;
            case 10: this.peso10--; break;
            case 20: this.peso20--; break;
            case 50: this.peso50--; break;
            case 100: this.peso100--; break;
            case 200: this.peso200--; break;
            case 500: this.peso500--; break;
            case 1000: this.peso1000--; break;
            default: System.out.println("Wrong Input!");

        }

        return returnType;

    }
    */

    public void resetMoney()    {
        this.peso1 = 0;
        this.peso5 = 0;
        this.peso10 = 0;
        this.peso20 = 0;
        this.peso50 = 0;        
        this.peso100 = 0;
        this.peso200 = 0;
        this.peso500 = 0;
        this.peso1000 = 0;
    }





    
    
}
