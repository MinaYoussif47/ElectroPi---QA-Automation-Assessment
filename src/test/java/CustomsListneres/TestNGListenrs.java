package CustomsListneres;

import org.testng.*;

public class TestNGListenrs implements
        IInvokedMethodListener,
        ITestNGListener,
        IExecutionListener,
        IRetryAnalyzer {

    private int attempts = 0;

    // Called when TestNG execution starts
    @Override
    public void onExecutionStart() {System.out.println("Execution Started");}

    // Called when TestNG execution finishes
    @Override
    public void onExecutionFinish() {
        System.out.println("Execution Finished");}

    // Called before a method is executed
    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(method.getTestMethod().getMethodName() + " started");}

    // Called after a method is executed
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println(
                method.getTestMethod().getMethodName() + " Finished");}

    // Retry failed test once
    @Override
    public boolean retry(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE && attempts == 0) {

            attempts++;

            System.out.println("Test Failed - Retrying...");

            return true;
        }

        return false;
    }
}