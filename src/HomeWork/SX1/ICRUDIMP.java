package HomeWork.SX1;

public class ICRUDIMP implements ICRUD {
    private Category[] categories;
    private int size = 0;

    public ICRUDIMP(int capacity) {
        categories = new Category[capacity];
    }

    @Override
    public Category[] findAll() {
        Category[] result = new Category[size];
        for (int i = 0; i < size; i++) {
            result[i] = categories[i];
        }
        return result;
    }

    @Override
    public void addCategory(Category category) {
        if (size >= categories.length) {
            System.out.println("Danh sach da day!");
            return;
        }
        categories[size++] = category;
        System.out.println("Them danh muc thanh cong!");
    }

    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < size; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i].setName(category.getName());
                categories[i].setDescription(category.getDescription());
                System.out.println("Cap nhat thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay danh muc co ID: " + category.getId());
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < size; i++) {
            if (categories[i].getId() == id) {
                for (int j = i; j < size - 1; j++) {
                    categories[j] = categories[j + 1];
                }
                categories[--size] = null;
                System.out.println("Xoa thanh cong!");
                return;
            }
        }
        System.out.println("Khong tim thay danh muc can xoa!");
    }
}
