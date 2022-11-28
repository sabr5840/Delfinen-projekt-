public class Payments {
    private int juniorMember = 1000;
    private int seniorMember = 1600;
    private int passiveMember = 500;
    private double totalPayments;

    public int getSeniorMember(){
    return seniorMember;
    }

    public int getJuniorMember() {
        return juniorMember;
    }

    public int getPassiveMember() {
        return passiveMember;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public void setJuniorMember(int juniorMember) {
        this.juniorMember = juniorMember;
    }

    public void setSeniorMember(int seniorMember) {
        this.seniorMember = seniorMember;
    }

    public void setPassiveMember(int passiveMember) {
        this.passiveMember = passiveMember;
    }

    public void setTotalPayments(double totalPayments) {
        this.totalPayments = totalPayments;
    }
}
