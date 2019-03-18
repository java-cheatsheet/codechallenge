
/*
import org.testng;
import org.testng.annotations.*;
*/
    /**
     * Username validator Testing
     * @author mkyong
     *
     */
    public class RegexUsernameValidatorTest {
/*
        private UsernameValidator usernameValidator;

        @BeforeClass
        public void initData(){
            usernameValidator = new UsernameValidator();
        }

        @DataProvider
        public Object[][] ValidUsernameProvider() {
            return new Object[][]{
                    {new String[] {
                            "mkyong34", "mkyong_2002","mkyong-2002" ,"mk3-4_yong"
                    }}
            };
        }

        @DataProvider
        public Object[][] InvalidUsernameProvider() {
            return new Object[][]{
                    {new String[] {
                            "mk","mk@yong","mkyong123456789_-"
                    }}
            };
        }

        @Test(dataProvider = "ValidUsernameProvider")
        public void ValidUsernameTest(String[] Username) {

            for(String temp : Username){
                boolean valid = usernameValidator.validate(temp);
                System.out.println("Username is valid : " + temp + " , " + valid);
                Assert.assertEquals(true, valid);
            }

        }

        @Test(dataProvider = "InvalidUsernameProvider",
                dependsOnMethods="ValidUsernameTest")
        public void InValidUsernameTest(String[] Username) {

            for(String temp : Username){
                boolean valid = usernameValidator.validate(temp);
                System.out.println("username is valid : " + temp + " , " + valid);
                Assert.assertEquals(false, valid);
            }

        }
    }
*/
    }
