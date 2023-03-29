package com.eyal.salesboard.Service;

import com.eyal.salesboard.Entity.Dto.Advertisement;
import com.eyal.salesboard.Entity.Dto.BaseProduct;
import com.eyal.salesboard.Entity.Enums.ProductTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AdvertisementService {

    @Autowired
    @Qualifier("support")
    List<Advertisement> advertisements;//= new ArrayList<>();
    @Autowired
    ProductService productService;

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void addAdvertisement(BaseProduct product) { //1
        Advertisement advertisement = new Advertisement();
        BaseProduct baseProduct = productService.buildProduct(product);
        advertisement.setProduct(baseProduct);
        advertisement.setId(baseProduct.getId());
        advertisements.add(advertisement);
    }
    public void addAdvertisementToFirst(BaseProduct baseProduct){
        Advertisement advertisement = new Advertisement();
        advertisement.setProduct(baseProduct);
        advertisement.setId(baseProduct.getId());
        advertisements.add(0, advertisement);
    }
    public List<Advertisement> filterBy(Predicate<? super Advertisement> predicate) { //6
        return advertisements.stream().filter(predicate).collect(Collectors.toList());
    }
    public List<Advertisement> filterByCost(int cost) { //6
        return filterBy(new Predicate<Advertisement>() {
            @Override
            public boolean test(Advertisement advertisement) {
                return advertisement.getProduct().getPrice() <= cost;
            }
        });
    }

    public List<Advertisement> filterByProductType(ProductTypeEnum productTypeEnum) { //5
        return filterBy(new Predicate<Advertisement>() {
            @Override
            public boolean test(Advertisement advertisement) {
                return advertisement.getProduct().getProductTypeEnum().equals(productTypeEnum);
            }
        });
    }

    public List<Advertisement> removeAdvertisement(int id) { //2
        advertisements.removeIf(advertisement -> advertisement.getProduct().getId() == id);
        return advertisements;
    }
    public Advertisement getAdvertisementById(int id){
        return advertisements.stream().filter(advertisement -> advertisement.getId() == id).toList().get(0);
    }
    public void editAdvertisement(BaseProduct baseProduct) {
        Advertisement advertisement = getAdvertisementById(baseProduct.getId());
        productService.updateProduct(baseProduct,advertisement.getProduct());
    }
    public void jumpAdvertisement(BaseProduct baseProduct) {
        Advertisement oldAdvertisement = getAdvertisementById(baseProduct.getId());
        removeAdvertisement(baseProduct.getId());
        addAdvertisementToFirst(baseProduct);
    }
}
