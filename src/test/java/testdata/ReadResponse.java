package testdata;

import io.restassured.path.json.JsonPath;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static core.Config.*;

public class ReadResponse {

    //	public static String MSISDN;
    private static String response = "";
    //private static String fileName = "Configurations//PAYM.json";
    private static String fileName = "";


    public static void ReadFile() {
        String user = getSegment();
        String TilEnv = getServer();
        String server = getServer();

        //fileName = VSTSFileUploader.fileNamePath;
        fileName = "Configurations//Responses//" + TilEnv + "//" + user + ".json";
        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                response += data + "\n";

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        response = response.replaceAll("\\{", "\\{\n");

    }

    public static String GetSubscriptionsListdResponse() {
        String SubsListResponse = "";
        Pattern pattern = Pattern.compile("GetSubscriptionsList : \\{(.*?)\\}\n  SubscriptionSwitch", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            SubsListResponse = matcher.group(1);
        }
        return SubsListResponse;
    }

    //	public static String GetSubscriptionsListdResponse() {
//		String SubsListResponse = "";
//		Pattern pattern = Pattern.compile("GetSubscriptionsList : \\{(.*?)\\}\n  SubscriptionSwitch", Pattern.DOTALL);
//		Matcher matcher = pattern.matcher(response);
//		if (matcher.find()) {
//			SubsListResponse = matcher.group(1);
//		}
//		return SubsListResponse;
//	}
    public static String GetSegmentAPIResponse() {
        String SegmentResponse = "";
        Pattern pattern = Pattern.compile("Segment : \\{(.*?)\\}\n  SubsConfigWithoutSegment", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            SegmentResponse = matcher.group(1);
        }
        return SegmentResponse;
    }

    public static String getAdditionalChargesDetailsResponse() {
        String additionalChargesDetailsResponse = "";
        Pattern pattern = Pattern.compile("AdditionalChargesDetails : \\{(.*?)\\}\n  Content", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            additionalChargesDetailsResponse = matcher.group(1);
            System.out.println("Additional Charges Details Api" + additionalChargesDetailsResponse);
        }
        return additionalChargesDetailsResponse;
    }

    public static HashMap<String, String> getNoOFBills() throws ParseException {
        String additionalChargesDetailsResponse = getAdditionalChargesDetailsResponse();
        HashMap<String, String> additionalChargesDetails = new HashMap<String, String>();

        JsonPath js1 = new JsonPath(additionalChargesDetailsResponse);
        String value = js1.getString("footerText");
        System.out.println("Footer Text" + value);
        String NoOfBills = "";
        String regex = "of(.*?)results";

        Pattern p = Pattern.compile(regex, Pattern.DOTALL);
        if (value != null) {
            Matcher m1 = p.matcher(value);
            if (m1.find()) {
                NoOfBills = m1.group(1);
                NoOfBills = NoOfBills.replaceAll("\\s+", "");
                additionalChargesDetails.put("NoOfBills", NoOfBills);
                System.out.println("NoOfBills" + NoOfBills);
            }
        }

        return additionalChargesDetails;
    }

    public static String GetAdditionalChargesAPIResponse() {
        String additionalChargesResponse = "";
        Pattern pattern = Pattern.compile("AdditionalCharges : \\{(.*?)\\}\n  Upgrades", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            additionalChargesResponse = matcher.group(1);
        }
        return additionalChargesResponse;
    }

    public static String getCurrentChargesAPIResponse() {
        String currentChargesResponse = "";
        Pattern pattern = Pattern.compile("CurrentCharges : \\{(.*?)\\}\n  AdditionalCharges", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            currentChargesResponse = matcher.group(1);
        }
        return currentChargesResponse;
    }

    public static String GetSegment() {
        String SegmentResponse = GetSegmentAPIResponse();
        String segment = "";
        Pattern pattern = Pattern.compile("segment\":\"(.*?)\",", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(SegmentResponse);
        if (matcher.find()) {
            segment = matcher.group(1);
        }
        return segment;
    }

    public static String GetSubscriptionType() {
        String SegmentResponse = GetSegmentAPIResponse();
        String SubscriptionType = "";
        Pattern pattern = Pattern.compile("name\":\"(.*?)\",", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(SegmentResponse);
        if (matcher.find()) {
            SubscriptionType = matcher.group(1);
        }
        return SubscriptionType;
    }

    public static String GetHansSoloResponse() {
        String HansSolo = "";
        Pattern pattern = Pattern.compile("HansSolo : \\{(.*?)\\}\n  SoftToken", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            HansSolo = matcher.group(1);
        }
        return HansSolo;
    }

    public static String GetDashboardResponse() {
        String Dashboard = "";
//		Pattern pattern = Pattern.compile("Dashboard : \\{(.*?)\\}\n  SubsConfigWithSegment", Pattern.DOTALL);
        Pattern pattern = Pattern.compile("Dashboard : \\{(.*?)SubsConfigWithSegment", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            Dashboard = matcher.group(1);
        }
        return Dashboard;
    }


    public static List<HashMap<String, String>> getAllowanceTile() throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        List<HashMap<String, String>> jsonObject2 = js1.getJsonObject("tiles[0].content");
        return jsonObject2;
    }

    public static String getAllowanceTileHeader(int i) throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getJsonObject("tiles[0].content[" + i + "].headerFallback");
        String value2 = value.replaceAll("<b>", "");
        value2 = value2.replaceAll("</b>", "");
        return value2;
    }

    public static String getAllowanceTileTitle(int i) throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getJsonObject("tiles[0].content[" + i + "].title");
        return value;
    }

    public static String getAllowanceTileSubTitle(int i) throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getJsonObject("tiles[0].content[" + i + "].subtitle");
        return value;
    }

    public static String getAllowanceTileUnit(int i) throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getJsonObject("tiles[0].content[" + i + "].remainingUnit");
        return value;
    }

    public static List<HashMap<String, String>> GetAssistanceLinksList() throws ParseException {
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        // String value = js1.getString("lastAPICall");
        List<HashMap<String, String>> jsonObject2 = js1.getJsonObject("linksMenu.menuItems.subItems[0]");
        return jsonObject2;
    }


    public static HashMap<String, String> getAdditionalChargesDetails() {
        String additionalCharges = GetAdditionalChargesAPIResponse();
        HashMap<String, String> additionalChargesContent = new HashMap<String, String>();

        JsonPath js1 = new JsonPath(additionalCharges);
        try {
            String value = js1.getString("list[0].quantity");
            System.out.println("Quantity is:" + value);
            additionalChargesContent.put("quantity", value);
            String value1 = js1.getString("list[0].detailAPIPageTitle");
            System.out.println("Header is:" + value1);

            String headerAfterRegex = "";
            String regex = ":([^)]+)";

            if (value1 != null) {
                Pattern p = Pattern.compile(regex, Pattern.DOTALL);
                Matcher m1 = p.matcher(value1);
                if (m1.find()) {
                    headerAfterRegex = m1.group(1);
                    headerAfterRegex = headerAfterRegex.replaceAll("\\s+", "");
                    additionalChargesContent.put("header", headerAfterRegex);
                    System.out.println("Header after regex:" + headerAfterRegex);
                }
            }
        } catch (Exception e) {
            System.out.println("API failed");
        }


        return additionalChargesContent;
    }

    public static HashMap<String, String> GetChargesCard() {
        String Dashboard = GetDashboardResponse();
        HashMap<String, String> chargesCardContent = new HashMap<String, String>();

        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getString("tiles[1].content[0].header");
        chargesCardContent.put("header", value);
        value = js1.getString("tiles[1].content[0].title");
        chargesCardContent.put("title", value);
        value = js1.getString("tiles[1].content[0].billPeriod");
        chargesCardContent.put("billPeriod", value);
        value = js1.getString("tiles[1].content[0].balance");
        chargesCardContent.put("balance", value);

        return chargesCardContent;
    }

    public static HashMap<String, String> getAdditionalChargesValue() {
        String Dashboard = getCurrentChargesAPIResponse();
        HashMap<String, String> chargesCardContent = new HashMap<String, String>();

        JsonPath js1 = new JsonPath(Dashboard);
        String value = js1.getString("additionalChargesCard.header.quantityValue");
        chargesCardContent.put("quantity", value);

        return chargesCardContent;
    }

    public static String GetDiscoverResponse() {
        String DiscoverResponse = "";
        Pattern pattern = Pattern.compile("Discover : \\{(.*?)\\}\n  AdditionalChargesDetails", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            DiscoverResponse = matcher.group(1);
        }
        return DiscoverResponse;
    }

    public static List<HashMap<String, String>> GetDsicoverOffers() throws ParseException {
        String Discover = GetDiscoverResponse();
        List<HashMap<String, String>> jsonObject;
        JsonPath js1 = new JsonPath(Discover);
        jsonObject = js1.getJsonObject("items");
        return jsonObject;
    }

    public static String GetVeryMeResponse() {
        String VeryMeResponse = "";
        Pattern pattern = Pattern.compile("VeryMe : \\{(.*?)\\}\n  Discover", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            VeryMeResponse = matcher.group(1);
        }
        return VeryMeResponse;
    }

    public static List<HashMap<String, String>> GetVeryMeOffers() throws ParseException {
        String VeryMe = GetVeryMeResponse();
        JsonPath js1 = new JsonPath(VeryMe);
        List<HashMap<String, String>> jsonObject = null;
        if (!VeryMe.contains("Very Me Api failed"))
            jsonObject = js1.getJsonObject("items");
        return jsonObject;
    }

    public static String GetPlanV3Response() {
        String PlanResponse = "";
        Pattern pattern = Pattern.compile("Plan : \\{(.*?)\\}\n  Usages", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            PlanResponse = matcher.group(1);
        }
        return PlanResponse;
    }

    public static String[] GetPlanV3Details() throws ParseException {
        String plan = GetPlanV3Response();

        String PlanResponse = "";
        Pattern pattern = Pattern.compile("list(.*?)]}]},\\{", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(plan);
        if (matcher.find()) {
            PlanResponse = matcher.group(1);
        }
        String[] PlanDetailsItems = PlanResponse.split("},\\{");

        return PlanDetailsItems;
    }

    public static String GetPAYGBalance() {
        String balance = "";
        String Dashboard = GetDashboardResponse();
        Pattern pattern = Pattern.compile("balance\":\"(.*?)\"}", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(Dashboard);
        if (matcher.find()) {
            balance = matcher.group(1);
        }
        return balance;
    }

    //    public static String GetSubscriptionsListdResponse() {
//		String SubsListResponse = "";
//		Pattern pattern = Pattern.compile("GetSubscriptionsList : \\{(.*?)\\}\n  SubscriptionSwitch", Pattern.DOTALL);
//		Matcher matcher = pattern.matcher(response);
//		if (matcher.find()) {
//			SubsListResponse = matcher.group(1);
//		}
//		return SubsListResponse;
//	}
    public static String GetAccountsResponse() {
        String AccountResponse = "";
        Pattern pattern = Pattern.compile("GetAccounts : \\{(.*?)\\}\n  GetSubscriptionsList", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            AccountResponse = matcher.group(1);
        }
        return AccountResponse;
    }

    public static String SubscriptionsListResponse() {
        String SubscriptionsListRespsone = GetSubscriptionsListdResponse();
        String SubsResponse = "";
        Pattern pattern = Pattern.compile("subscriptions\":\\[\\{(.*?)\\},", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(SubscriptionsListRespsone);
        if (matcher.find()) {
            SubsResponse = matcher.group(1);
        }
        return SubsResponse;
    }

    public static List<HashMap<String, String>> getSubsList() {
        String subsList = GetSubscriptionsListdResponse();
        JsonPath js1 = new JsonPath(subsList);
        List<HashMap<String, String>> jsonObject2 = js1.getJsonObject("subscriptions");
        return jsonObject2;
    }

    public static Boolean CheckSubscriptionHas(String userType) throws ParseException {
        String Segment = "";
        Boolean exist = false;
        for (int i = 1; i <= getSubsList().size() - 1; i++) {
            Segment = getSubsType(i);
            if (Segment.equals(userType)) {
                exist = true;
                break;
            }
        }
        return exist;
    }


    public static String GetExtrasAPIResponse() {
        String ExtrasResponse = "";
        String regex = "caps</b>\",\"displayType\":\"EXTRAS_CARD\",\"list\":(.*?)CurrentCharges";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            ExtrasResponse = matcher.group(1);
        }
        return ExtrasResponse;
    }

    public static String GetExtraAllowancesAPIResponse() {
        String ExtrasResponse = "";
        String regex = "allowances</b>\",\"displayType\":\"EXTRAS_CARD\",\"list\":(.*?)Data cap";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            ExtrasResponse = matcher.group(1);
        }
        return ExtrasResponse;
    }

    public static HashMap<String, String> GetExtras() {
        String SegmentResponse = GetExtrasAPIResponse();
        HashMap<String, String> ExtrasContent = new HashMap<String, String>();
        Pattern pattern = Pattern.compile("\"title\":\"(.*?)\",\"subContent\"", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(SegmentResponse);
        for (int i = 1; matcher.find(); i++) {
            ExtrasContent.put(Integer.toString(i), matcher.group(1));
        }
        return ExtrasContent;
    }

    public static HashMap<String, String> GetExtraAllowances() {
        String SegmentResponse = GetExtraAllowancesAPIResponse();
        HashMap<String, String> ExtrasContent = new HashMap<String, String>();
        Pattern pattern = Pattern.compile("\"title\":\"(.*?)\",\"text\"", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(SegmentResponse);
        for (int i = 1; matcher.find(); i++) {
            ExtrasContent.put(Integer.toString(i), matcher.group(1));
        }
        return ExtrasContent;
    }

    public static boolean checkReturnedExtraAllowance() {
        boolean x = false;
        if (!(GetExtraAllowancesAPIResponse().isEmpty())) {
            x = true;
        }
        return x;
    }

    public static HashMap<String, String> GetUsageAPIRecurringExtrasResponse() {
        int i, counter = 2;
        String UsageAPIRecurringExtrasResponse = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsageRecurringExtra = new HashMap<String, String>();
        String regex = "title\":\"Recurring extras\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsageAPIRecurringExtrasResponse = "\"Recurring extras\"," + matcher.group(1);
        }
        if (!(UsageAPIRecurringExtrasResponse.isEmpty())) {
            UsageRecurringExtra.put("1", "Recurring extras");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsageAPIRecurringExtrasResponse);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata"))) {
                    UsageRecurringExtra.put(Integer.toString(counter), matcher1.group(1));
                    counter++;
                }
            }
            UsageRecurringExtra.put(Integer.toString(counter), "Manage extras, caps and bars");
        }
        return UsageRecurringExtra;
    }

    public static boolean checkReturnedUsageAPIRecurringExtras() {
        boolean x = false;
        if (GetUsageAPIRecurringExtrasResponse().containsValue("Recurring extras")) {
            x = true;
        }
        return x;
    }

    public static HashMap<String, String> GetUsageAPIOneTimeExtrasResponse() {
        int i, counter = 2;
        String UsageAPIOneTimeExtrasResponse = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsageOneTimeExtra = new HashMap<String, String>();
        String regex = "title\":\"One-time extras\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsageAPIOneTimeExtrasResponse = "\"One-time extras\"," + matcher.group(1);
        }
        if (!(UsageAPIOneTimeExtrasResponse.isEmpty())) {
            UsageOneTimeExtra.put("1", "One-time extras");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsageAPIOneTimeExtrasResponse);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata"))) {
                    UsageOneTimeExtra.put(Integer.toString(counter), matcher1.group(1));
                    counter++;
                }
            }

        }
        return UsageOneTimeExtra;
    }

    public static boolean checkReturnedUsageAPIOneTimeExtras() {
        boolean x = false;
        if (GetUsageAPIOneTimeExtrasResponse().containsValue("One-time extras")) {
            x = true;
        }
        return x;
    }

    public static boolean checkReturnedUsageAPIPlan() {
        boolean x = false;
        if (GetUsageAPIPlanResponse().containsValue("Plan")) {
            x = true;
        }
        return x;
    }

    public static HashMap<String, String> GetUsageAPIPlanResponse() {
        int i, counter = 2;
        String UsagePlanResponse = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsagePlan = new HashMap<String, String>();
        String regex = "title\":\"Plan\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsagePlanResponse = "\"Plan\"," + matcher.group(1);
        }
        if (!(UsagePlanResponse.isEmpty())) {
            UsagePlan.put("1", "Plan");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsagePlanResponse);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata"))) {
                    UsagePlan.put(Integer.toString(counter), matcher1.group(1));
                    counter++;
                }
            }
            UsagePlan.put(Integer.toString(counter), "View plan");
        }
        return UsagePlan;
    }

    public static HashMap<String, String> GetUsageAPIBVBResponse() {
        int i, counter = 2;
        String UsageAPIBVBResponse = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsageBVB = new HashMap<String, String>();
        String regex = "title\":\"Big value bundle\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsageAPIBVBResponse = "\"Big value bundle\"," + matcher.group(1);
        }
        System.out.println(UsageAPIBVBResponse);
        //UsageAPIOneTimeExtrasResponse = "";
        if (!(UsageAPIBVBResponse.isEmpty())) {
            UsageBVB.put("1", "Big value bundle");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsageAPIBVBResponse);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata") || matcher1.group(1).equals("Texts") || matcher1.group(1).equals("Minutes"))) {
                    UsageBVB.put(Integer.toString(counter), matcher1.group(1));
                    counter++;
                }
            }
            UsageBVB.put(Integer.toString(counter), "View plan");
        }
        return UsageBVB;
    }

    public static boolean checkReturnedUsageAPIBVB() {
        boolean x = false;
        if (GetUsageAPIBVBResponse().containsValue("Big value bundle")) {
            x = true;
        }
        return x;
    }

    public static HashMap<String, String> GetUsageAPIPAYGSimplyResponse() {
        int i;
        String UsageAPIPAYGSimplyResponse = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsagePAYGSimply = new HashMap<String, String>();
        String regex = "title\":\"Pay as you go Simply\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsageAPIPAYGSimplyResponse = "\"Pay as you go Simply\"," + matcher.group(1);
        }
        if (!(UsageAPIPAYGSimplyResponse.isEmpty())) {
            UsagePAYGSimply.put("1", "Pay as you go Simply");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"}]}]", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsageAPIPAYGSimplyResponse);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata") || matcher1.group(1).equals("Texts") || matcher1.group(1).equals("Minutes"))) {
                    String x = matcher1.group(1).replace(" <a href=\\\"myvodafone://SIMPLY_PLAN_CALL_CHARGES\\\">", "");
                    String y = x.replace(" </a>", "");
                    UsagePAYGSimply.put(Integer.toString(i), y);
                }
            }
        }
        return UsagePAYGSimply;
    }

    public static boolean checkReturnedUsageAPIPAYGSimply() {
        boolean x = false;
        if (GetUsageAPIPAYGSimplyResponse().containsValue("Pay as you go Simply")) {
            x = true;
        }
        return x;
    }

    public static String GetUsageAPIResponse() {
        String UsageResponse = "";
        String regex = "Usages : \\{(.*?)Extras";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            UsageResponse = matcher.group(1);
        }
        //System.out.println(UsageResponse);
        return UsageResponse;
    }

    public static HashMap<String, String> GetUsageAPIPAYG1Response() {
        int i;
        String UsageAPIPAYG1Response = "";
        String UsageResponse = GetUsageAPIResponse();
        HashMap<String, String> UsagePAYG1 = new HashMap<String, String>();
        String regex = "title\":\"Pay as you go 1\",(.*?)buttons";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(UsageResponse);
        if (matcher.find()) {
            UsageAPIPAYG1Response = "\"Pay as you go 1\"," + matcher.group(1);
        }
        System.out.println(UsageAPIPAYG1Response);
        //UsageAPIOneTimeExtrasResponse = "";
        if (!(UsageAPIPAYG1Response.isEmpty())) {
            UsagePAYG1.put("1", "Pay as you go 1");
            Pattern pattern1 = Pattern.compile("header\":\"(.*?)\"}]}]", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(UsageAPIPAYG1Response);
            for (i = 2; matcher1.find(); i++) {
                if (!(matcher1.group(1).equals("testdata") || matcher1.group(1).equals("Texts") || matcher1.group(1).equals("Minutes"))) {
                    UsagePAYG1.put(Integer.toString(i), matcher1.group(1));
                }
            }
            //UsagePAYGSimply.put(Integer.toString(i+1),"View plan");
            for (String name : UsagePAYG1.values()) {
                System.out.println(name);
            }
        }
        return UsagePAYG1;
    }

    public static boolean checkReturnedUsageAPIPAYG1() {
        boolean x = false;
        if (GetUsageAPIPAYG1Response().containsValue("Pay as you go 1")) {
            x = true;
        }
        return x;
    }

    public static LinkedHashMap<String, String> GetBillingMonths() {
        LinkedHashMap<String, String> billingOfMonths = new LinkedHashMap<String, String>();
        String months = "";
        String BillingResponse = GetBillingAPIResponse();
        String regex = "recentBills\":(.*?),\"accountName";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(BillingResponse);
        if (matcher.find()) {
            months = matcher.group(1);
        }
        String month = "";
        String regex1 = "title\":(.*?),\"shortTitle";
        Pattern pattern1 = Pattern.compile(regex1, Pattern.DOTALL);
        Matcher matcher1 = pattern1.matcher(months);
        for (int i = 1; matcher1.find(); i++) {
            String singleMonth = "";
            String singleBillAmount = "";
            String singleBillPeriod = "";
            String singleBillText = "";
            month = matcher1.group(1);
            String regexMonth = "\"(.*?)\"";
            Pattern pattern2 = Pattern.compile(regexMonth, Pattern.DOTALL);
            Matcher matcher2 = pattern2.matcher(month);
            if (matcher2.find()) {
                singleMonth = matcher2.group(1);
            }
            billingOfMonths.put("Month of " + i, singleMonth);
            String regexBillAmount = "billAmount\":\"(.*?)\"";
            Pattern pattern3 = Pattern.compile(regexBillAmount, Pattern.DOTALL);
            Matcher matcher3 = pattern3.matcher(month);
            if (matcher3.find()) {
                singleBillAmount = matcher3.group(1);
            }
            billingOfMonths.put("Bill amount of " + i, singleBillAmount);
            String regexBillPeriod = "billPeriod\":\"(.*?)\"";
            Pattern pattern4 = Pattern.compile(regexBillPeriod, Pattern.DOTALL);
            Matcher matcher4 = pattern4.matcher(month);
            if (matcher4.find()) {
                singleBillPeriod = matcher4.group(1);
            }
            billingOfMonths.put("Bill period of " + i, singleBillPeriod.replace("<b>", "").replace("</b>", ""));
            String regexBillText = "billText\":\"(.*?)\"";
            Pattern pattern5 = Pattern.compile(regexBillText, Pattern.DOTALL);
            Matcher matcher5 = pattern5.matcher(month);
            if (matcher5.find()) {
                singleBillText = matcher5.group(1);
            }
            billingOfMonths.put("Bill text of " + i, singleBillText.replace("<b>", "").replace("</b>", ""));

        }
        return billingOfMonths;
    }

    public static String GetBillingAPIResponse() {
        String BillingResponse = "";
        String regex = "BillHistory : \\{(.*?)Plan";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            BillingResponse = matcher.group(1);
        }
        return BillingResponse;
    }

    public static String GetBillingAccountName() {
        String accountName = "";
        String BillingResponse = GetBillingAPIResponse();
        String regex = "accountName\":\"<b>Account: (.*?)</b>";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(BillingResponse);
        if (matcher.find()) {
            accountName = matcher.group(1);
        }
        return accountName;
    }

    public static boolean checkVatsAppearance() {
        boolean VatsAppear = false;
        LinkedHashMap<String, String> billingOfMonths = GetBillingMonths();
        if (billingOfMonths.size() > 0) {
            VatsAppear = true;
        }
        return VatsAppear;
    }

    public static boolean checkBillingGraphAppearance() {
        boolean graghAppear = false;
        LinkedHashMap<String, String> billingOfMonths = GetBillingMonths();
        if (billingOfMonths.size() > 12) {
            graghAppear = true;
        }
        return graghAppear;
    }

    public static void main(String[] args) throws InterruptedException, ParseException {
        ReadFile();
        System.out.println("Response is:" + getAllowanceTileHeader(1));
        for (int i = 0; i < getAllowanceTile().size() - 2; i++) {


        }
    }

    public static String GetNewPlanResponse() {
        String PlanResponse = "";
        Pattern pattern = Pattern.compile("Plan : \\{(.*?)Usages", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            PlanResponse = matcher.group(1);
        }
        return PlanResponse;
    }

    public static LinkedHashMap<String, String> GetNewPlanCards() {
        String newPlanResponse = GetNewPlanResponse();
        LinkedHashMap<String, String> cards = new LinkedHashMap<String, String>();
        JsonPath js1 = new JsonPath(newPlanResponse);
        for (int i = 0; js1.getString("cards[" + i + "]") != null; i++) {
            String value = js1.getString("cards[" + i + "]");
            cards.put("card of " + i, value);
        }
        return cards;
    }

    public static LinkedHashMap<String, String> GetNewPlanPageForPAYG() {
        int i = 1;
        LinkedHashMap<String, String> cards = GetNewPlanCards();
        LinkedHashMap<String, String> planPage = new LinkedHashMap<String, String>();
        for (String name : cards.values()) {
            Pattern pattern1 = Pattern.compile("title:<b>(.*?)</b>", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(name);
            if (matcher1.find()) {
                planPage.put("Title of card " + i, matcher1.group(1));
            }

            Pattern pattern = Pattern.compile("text:(.*?), title", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                planPage.put("Text of card " + i, matcher.group(1)
                        .replace("<a href=\"myvodafone://SIMPLY_PLAN_CALL_CHARGES\"> ", "")
                        .replace("</a>", ""));
            }

            if (name.contains("action")) {
                Pattern pattern2 = Pattern.compile("actions:\\[\\[text:(.*?),", Pattern.DOTALL);
                Matcher matcher2 = pattern2.matcher(name);
                if (matcher2.find()) {
                    planPage.put("action of card " + i, matcher2.group(1));
                }
            }
            i++;
        }

        for (String name : planPage.values()) {
            System.out.println(name);
        }

        return planPage;
    }

    public static String GetNewPlanDetails() {
        LinkedHashMap<String, String> cards = GetNewPlanCards();
        String planDetails = "";
        for (String name : cards.values()) {
            if (name.contains("<b>Your Plan</b>")) {
                planDetails = name;
            }
        }
        //System.out.println(planDetails);
        return planDetails;
    }

    public static String GetNewPlanTitle() {
        String newPlanResponse = GetNewPlanDetails();
        String planTitle = "";
        Pattern pattern = Pattern.compile("title:(.*?),", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(newPlanResponse);
        if (matcher.find()) {
            planTitle = matcher.group(1);
        }
        return planTitle;
    }

    public static LinkedHashMap<String, String> GetNewPlanSectionTitles() {
        String newPlanResponse = GetNewPlanDetails();
        LinkedHashMap<String, String> sectionTitles = new LinkedHashMap<String, String>();
        String sectionTitle = "";
        Pattern pattern = Pattern.compile("title:<b>(.*?)</b>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(newPlanResponse);
        for (int i = 0; matcher.find(); i++) {
            sectionTitle = matcher.group(1);
            sectionTitles.put("Section title no." + i, sectionTitle);
        }
        return sectionTitles;
    }

    public static LinkedHashMap<String, String> GetNewPlanIncludesChevrons() {
        String newPlanResponse = GetNewPlanDetails();
        LinkedHashMap<String, String> includesChevrons = new LinkedHashMap<String, String>();
        String includes = "";
        String includesChevron = "";
        String includesChevronText = "";
        System.out.println(newPlanResponse);
        Pattern pattern1 = Pattern.compile("title:<b>Includes</b>(.*)\\]\\]\\]", Pattern.DOTALL);
        Matcher matcher1 = pattern1.matcher(newPlanResponse);
        if (matcher1.find()) {
            includes = matcher1.group(1) + ",";
            System.out.println(includes);
            Pattern pattern = Pattern.compile("title:(.*?),", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(includes);
            Pattern pattern2 = Pattern.compile("subContentText:(.*?), subContentImageId", Pattern.DOTALL);
            Matcher matcher2 = pattern2.matcher(includes);
            while (matcher.find()) {
                includesChevron = matcher.group(1);
                if (matcher2.find()) {
                    includesChevronText = matcher2.group(1);
                    includesChevrons.put(includesChevronText, includesChevron);
                } else {
                    includesChevron = includesChevron.replace("]", "");
                    includesChevrons.put(includesChevron + " has no chevron", includesChevron);
                }
            }
        }

        return includesChevrons;
    }

    public static LinkedHashMap<String, String> GetNewPlanDetailsAllowances() {
        String planDetails = GetNewPlanDetails();
        String allowances = "";
        String allowanceText = "";
        String allowanceValue = "";
        LinkedHashMap<String, String> planAllowances = new LinkedHashMap<String, String>();
        Pattern pattern = Pattern.compile("Your Plan(.*?)\\]\\]\\]", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(planDetails);
        if (matcher.find()) {
            allowances = matcher.group(1) + "]";
        }

        Pattern pattern1 = Pattern.compile("\\[(.*?)\\]", Pattern.DOTALL);
        Matcher matcher1 = pattern1.matcher(allowances);
        while (matcher1.find()) {
            String x = "[" + matcher1.group(1) + "]";
            Pattern pattern2 = Pattern.compile("leftAlignedText:(.*?),", Pattern.DOTALL);
            Matcher matcher2 = pattern2.matcher(x);
            if (matcher2.find()) {
                allowanceText = matcher2.group(1);
            }

            Pattern pattern3 = Pattern.compile("rightAlignedText:(.*?)]", Pattern.DOTALL);
            Matcher matcher3 = pattern3.matcher(x);
            if (matcher3.find()) {
                allowanceValue = matcher3.group(1);
            }
            planAllowances.put(allowanceText, allowanceValue);

        }

        for (String name : planAllowances.values()) {
            System.out.println(name);
        }


        return planAllowances;
    }

    public static String GetNewPlanCTAForBVB() {
        String newPlanResponse = GetNewPlanDetails();
        String BVBPlanCTA = "";
        Pattern pattern = Pattern.compile("actions:\\[\\[text:(.*?),", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(newPlanResponse);
        if (matcher.find()) {
            BVBPlanCTA = matcher.group(1);
        }
        System.out.println(BVBPlanCTA);
        return BVBPlanCTA;
    }

    public static LinkedHashMap<String, String> GetNewPlanOffersCardForBVB() {
        LinkedHashMap<String, String> cards = GetNewPlanCards();
        LinkedHashMap<String, String> offersCard = new LinkedHashMap<String, String>();
        String planDetails = "";
        for (String name : cards.values()) {
            if (name.contains("Offers for you")) {
                planDetails = name;
            }
        }
        Pattern pattern1 = Pattern.compile("title:(.*?),", Pattern.DOTALL);
        Matcher matcher1 = pattern1.matcher(planDetails);
        if (matcher1.find()) {
            offersCard.put("Title", matcher1.group(1)
                    .replace("<b>", "").replace("</b>", ""));
        }

        Pattern pattern = Pattern.compile("text:(.*?), title", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(planDetails);
        if (matcher.find()) {
            offersCard.put("Text", matcher.group(1).
                    replace("<b>", "").replace("</b>", ""));
        }

        if (planDetails.contains("action")) {
            Pattern pattern2 = Pattern.compile("actions:\\[\\[text:(.*?),", Pattern.DOTALL);
            Matcher matcher2 = pattern2.matcher(planDetails);
            if (matcher2.find()) {
                offersCard.put("action", matcher2.group(1)
                        .replace("<b>", "").replace("</b>", ""));
            }
        }
        for (String name : offersCard.keySet()) {
            System.out.println(name);
        }

        return offersCard;
    }

    public static LinkedHashMap<String, String> GetUpgradeCards() {
        LinkedHashMap<String, String> upgradeCards = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> upgrades = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> cards = GetNewPlanCards();
        //int i = 1;
        for (String name : cards.values()) {
            if (name.contains("how to upgrade") && name.contains("You're eligible to upgrade")) {
                upgradeCards.put("Upgrade eligible", name.replace("<b>", "").replace("</b>", ""));
                //i++;
            } else if (name.contains("how to upgrade") && name.contains("Keep reaching your data limit?")) {
                upgradeCards.put("Keep reaching", name.replace("<b>", "").replace("</b>", ""));
            } else if (name.contains("how to upgrade") && name.contains("Fancy a new phone")) {
                upgradeCards.put("Fancy", name.replace("<b>", "").replace("</b>", ""));
            } else if (name.contains("aren't eligible for an upgrade")) {
                upgradeCards.put("Upgrade not eligible", name.replace("<b>", "").replace("</b>", ""));
            }
        }

        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            String regex = "";
            if (!(((String) mapElement.getValue()).contains("aren't eligible for an upgrade"))) {
                regex = "title:(.*?),";
            } else {
                regex = "title:(.*?)\\]";
            }
            Pattern pattern1 = Pattern.compile(regex, Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(((String) mapElement.getValue()));
            if (matcher1.find()) {
                upgrades.put("title of " + mapElement.getKey(), matcher1.group(1));
            }

            Pattern pattern = Pattern.compile("text:(.*?), title", Pattern.DOTALL);
            Matcher matcher = pattern.matcher(((String) mapElement.getValue()));
            if (matcher.find()) {
                upgrades.put("text of " + mapElement.getKey(), matcher.group(1));
            }

            if (((String) mapElement.getValue()).contains("actions")) {
                Pattern pattern4 = Pattern.compile("actions:\\[(.*?)\\]", Pattern.DOTALL);
                Matcher matcher4 = pattern4.matcher(((String) mapElement.getValue()));
                if (matcher4.find()) {
                    Pattern pattern2 = Pattern.compile("text:(.*?), journeyKey", Pattern.DOTALL);
                    Matcher matcher2 = pattern2.matcher(matcher4.group(1));
                    if (matcher2.find()) {
                        upgrades.put("action of " + mapElement.getKey(), matcher2.group(1));
                    }
                }
            }
        }

        for (String name : upgrades.keySet()) {
            System.out.println(name);
        }
        return upgrades;
    }

    public static boolean CheckListContain(HashMap<String, String> includesChevrons, String item) {
        boolean exist = false;
        for (String includesChevron : includesChevrons.values()) {
            if (includesChevron.equals(item)) {
                exist = true;
                break;
            }
        }
        return exist;
    }

    public static String getSubsType(int i) throws ParseException {
        String subsList = GetSubscriptionsListdResponse();
        JsonPath js1 = new JsonPath(subsList);
        String value = js1.getString("subscriptions[" + i + "].subscriptionType.name");
        System.out.println(value);
        return value;
    }

    /*public static String getAccountId(int i) throws ParseException {
        String accountsList = GetAccountsResponse();
        JsonPath js1 = new JsonPath(accountsList);
        String value = js1.getString("accounts["+i+"].accountId");
        System.out.println(value);
        return value;
    }*/
    public static List<HashMap<String, String>> getAccountIds() throws ParseException {
        String accountsList = GetAccountsResponse();
        JsonPath js1 = new JsonPath(accountsList);
        List<HashMap<String, String>> jsonObject2 = js1.getJsonObject("accounts");
        return jsonObject2;
    }

    public static String GetVOVAPIResponse() {
        String VOVResponse = "";
        Pattern pattern = Pattern.compile("VOV : \\{(.*?)PasswordLogin", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            VOVResponse = matcher.group(1);
        }
        //System.out.println(VOVResponse);
        return VOVResponse;
    }

    public static LinkedHashMap<String, String> GetVOVNotifications() {
        String VOVResponse = GetVOVAPIResponse();
        LinkedHashMap<String, String> notifications = new LinkedHashMap<String, String>();
        LinkedHashMap<String, String> VOVs = new LinkedHashMap<String, String>();
        Pattern pattern = Pattern.compile("id\":(.*?)Notifications", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(VOVResponse);
        int i = 1;
        while (matcher.find()) {
            if (matcher.group(1).contains("title")) {
                notifications.put("id of VOV no. " + i, matcher.group(1));
                i++;
            }
        }

        int j = 1;
        for (String name : notifications.values()) {
            Pattern pattern1 = Pattern.compile("title\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher1 = pattern1.matcher(name);
            if (matcher1.find()) {
                VOVs.put("title of VOV no. " + j + " of " + matcher1.group(1) + " card", matcher1.group(1));
            }
            Pattern pattern2 = Pattern.compile("message\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher2 = pattern2.matcher(name);
            if (matcher2.find()) {
                VOVs.put("text of VOV no. " + j + " of " + matcher1.group(1) + " card", matcher2.group(1));
            }
            String buttons = "";
            Pattern pattern3 = Pattern.compile("buttons(.*?)renderType", Pattern.DOTALL);
            Matcher matcher3 = pattern3.matcher(name);
            if (matcher3.find()) {
                buttons = matcher3.group(1);
            }

            Pattern pattern4 = Pattern.compile("title\":\"(.*?)\"", Pattern.DOTALL);
            Matcher matcher4 = pattern4.matcher(buttons);
            int buttonNo = 1;
            while (matcher4.find()) {
                VOVs.put("action no. " + buttonNo + " of VOV no. " + j + " of " + matcher1.group(1) + " card", matcher4.group(1));
                buttonNo++;
            }


            j++;
        }
/*
        for (String name : VOVs.keySet()) {
            System.out.println(name);
        }
        System.out.println("size is "+VOVs.size());

 */

        return VOVs;
    }

    public static boolean checkActiveLoans() throws ParseException {
        boolean existActiveLoan = false;
        String Dashboard = GetDashboardResponse();
        JsonPath js1 = new JsonPath(Dashboard);
        List<HashMap<String, String>> jsonObject2 = js1.getJsonObject("subsOverlay.tabs");
        if (jsonObject2.get(1).get("name").equals("Device Plan")) {
            existActiveLoan = true;
        }
        return existActiveLoan;
    }

    public static String GetHintApi() {
        String HintResponse = "";
        Pattern pattern = Pattern.compile("hint : \\{(.*?)\\}\n\\}", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            HintResponse = matcher.group(1);
        }
        return HintResponse;
    }

    public static String GetHintCode() {
        String HintAPI = GetHintApi();
        String HintCode = "";
        Pattern pattern = Pattern.compile("code\":(.*?),", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(HintAPI);
        if (matcher.find()) {
            HintCode = matcher.group(1);
        }
        return HintCode;
    }

    public static String GetPaymentCardApi() {
        String HintResponse = "";
        Pattern pattern = Pattern.compile("PaymentCard : \\{(.*?)\\}\n\\}", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(response);
        if (matcher.find()) {
            HintResponse = matcher.group(1);
        }
        return HintResponse;
    }

    public static String GetPaymentCardList() {
        String PaymentCardApiResponse = GetPaymentCardApi();
        String card = "";
        Pattern pattern = Pattern.compile("list\":(.*?)\"]", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(PaymentCardApiResponse);
        if (matcher.find()) {
            card = matcher.group(1);
        }
        card = card.replace("[", "");
        card = card.replace("\"", "");
        return card;
    }
}
