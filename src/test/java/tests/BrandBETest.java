package tests;

import models.*;
import org.testng.annotations.Test;
import services.BrandService;
import services.UserService;
import types.RequestStatusType;

public class BrandBETest{

    @Test
    public void BrandBETest() {
        //Pasul 1: Creem un brand
        RequestBrandModel requestBody = new RequestBrandModel("Brand", "Testing");

        BrandService brandService = new BrandService();
        ResponseBrandModel responseBody = brandService.createBrand(requestBody);

        //Pasul 2: Verificam daca s-a creat brandul
        brandService.checkSpecificBrand(responseBody.getId(), RequestStatusType.RESPONSE_OK);

        //Pasul 3: Modificam un brand
        RequestBrandModel requestBody3 = new RequestBrandModel("Oana", "Testing");
        brandService.modifySpecificBrand(requestBody3, responseBody.getId());

        //Pasul 4: Verificam daca s-a creat brandul
        brandService.checkSpecificBrand(responseBody.getId(), RequestStatusType.RESPONSE_OK);

        //Pasul 5: Ne logam cu admin creat
        UserService userService = new UserService();
        RequestUserLoginModel requestAdminBody = new RequestUserLoginModel("admin@practicesoftwaretesting.com", "welcome01");
        ResponseUserLoginModel responseAdminBody = userService.loginUser(requestAdminBody);

        //Pasul 6: Stergem brandul
        brandService.deleteSpecificBrand(responseAdminBody.getAccess_token(), responseBody.getId());

        //Pasul 7: Verificam ca brandul s-a sters
        brandService.checkSpecificBrand(responseBody.getId(), RequestStatusType.RESPONSE_NOT_FOUND);
    }}