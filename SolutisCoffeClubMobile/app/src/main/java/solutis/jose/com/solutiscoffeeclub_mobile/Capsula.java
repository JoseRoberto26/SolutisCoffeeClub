package solutis.jose.com.solutiscoffeeclub_mobile;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Capsula {

    @SerializedName("id")
    @Expose
    private Long id;

    @SerializedName("marca")
    @Expose
    private String marca;

    @SerializedName("sabor")
    @Expose
    private String sabor;

    @SerializedName("doses")
    @Expose
    private Integer doses;

    public Capsula() {
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Integer getDoses() {
        return doses;
    }

    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
