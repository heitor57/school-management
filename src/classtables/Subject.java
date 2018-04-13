/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classtables;

/**
 *
 * @author heitor
 */
public class Subject {
    private int su_id;
    private String su_name,su_description;
    private Integer p_id;

    public int getSu_id() {
        return su_id;
    }

    public void setSu_id(int su_id) {
        this.su_id = su_id;
    }

    public String getSu_name() {
        return su_name;
    }

    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }

    public String getSu_description() {
        return su_description;
    }

    public void setSu_description(String su_description) {
        this.su_description = su_description;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }


    
}
