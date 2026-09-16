class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 101);
        HallTicket copy = priya;

        copy.seatNumber = 205;
        System.out.println("Priya's seat number via original reference: " + priya.seatNumber);

        System.out.println("priya == copy: " + (priya == copy));

        HallTicket separate = new HallTicket("Priya", 205);
        System.out.println("priya == separate: " + (priya == separate));
    }
}
