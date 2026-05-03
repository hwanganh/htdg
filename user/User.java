package user;
import entity.Entity;
public abstract class User extends Entity {
    protected String userName;
    protected String passWord;
    protected String email;

    public boolean login(String userName, String passWord) {
        // DANG LAM O MOT FILE KHAC
        return false;
    }
}