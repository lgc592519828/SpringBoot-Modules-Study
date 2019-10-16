package cn.gcheng.springboot.entity;

/**
 * @author gcheng.L
 * @create 2019-10-11 14:33
 */
public class SysUser {

    private String id;
    private String username;
    private String password;
    private int    locked;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
