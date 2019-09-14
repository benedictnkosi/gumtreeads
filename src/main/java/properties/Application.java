package properties;

public class Application {

    public static String  dataFilePath="C:\\web_dev\\";
    public static String  imagesFilePath="C:\\Web_Dev\\gumtree_business\\images_chrome\\";
    public static String  dataFileName="gumtree_test_cases.xlsx";
    public static String  baseUrl="https://www.gumtree.co.za/";
    public static String  imagesDelimeter =",";
    public static int  timeoutSeconds=60;
    public static int  uploadImagesTimeOut=180;
    public static String  screenshotPath="/GumtreeAdsAutomation/FailedTestsScreenshots/";
    public static String  screenshotFolderName="/GumtreeAdsAutomation/FailedTestsScreenshots/";

    public static String  loginPageUlr="login.html";
    public static String  myAdsPageUlr="my/ads.html";
    public static String  createAdUlr="post.html";

    public static String  RunIndicatorColumnHeader="RUN";

    //application messages
    public static String  msg_success_create_custom_transaction = "successfully captured new transaction name";
    public static String  msg_success_delete_custom_transaction = "successfully deleted transaction name";
    public static String  msg_success_add_new_budget_item = "successfully captured new budget item";

    //excel tab names
    public static String  login_sheet_name = "001_login";
    public static String  short_term_rental_sheet_name = "short_term_accomodation";
    public static String  services_sheet_name = "services";
}
