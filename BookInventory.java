class BookInventory {
    String title;
    String author;
    int copiesAvailable;

    BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    void printEntry() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Copies Available: " + copiesAvailable);
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        BookInventory[] books = new BookInventory[4];
        books[0] = new BookInventory("The Alchemist", "Paulo Coelho", 5);
        books[1] = new BookInventory("1984", "George Orwell", 3);
        books[2] = new BookInventory("Clean Code", "Robert Martin", 7);
        books[3] = new BookInventory("Wings of Fire", "A.P.J. Abdul Kalam", 4);

        for (int i = 0; i < books.length; i++) {
            books[i].printEntry();
        }
    }
}
