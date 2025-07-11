package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "image_path")
    private String imagePath; // 儲存圖片路徑

    @ManyToOne(fetch = FetchType.LAZY) //LAZY:懶載入，只有真的要用圖片時才查資料，效能佳;EAGER:立即載入，每次查 product 就會一起查 images
    @JoinColumn(name = "product_id") // 外鍵欄位
    private Product product; //這張圖片所屬的 product 是誰

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
