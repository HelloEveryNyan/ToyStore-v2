public class ToyStoreProject {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.put(1, "Constructor", 1);
        toyShop.put(2, "Robot", 2);
        toyShop.put(3, "Doll", 3);

        toyShop.processAndGet(10);
    }
}
