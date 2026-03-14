import models.RequestUserLoginModel;
import models.ResponseUserLoginModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.ReportService;
import services.UserService;

public class ReportBETest {

    @Test
    public void testMethod(){
        RequestUserLoginModel requestBody = new RequestUserLoginModel("admin@practicesoftwaretesting.com", "welcome01");
        UserService userService = new UserService();
        ResponseUserLoginModel responseBody = userService.loginUser(requestBody);
        ReportService reportService = new ReportService();
        reportService.generateAverageSalesPerMonthReport(responseBody.getAccess_token());
    }
}