package com.uom.cps3230.login;

import com.uom.cps3230.login.enums.LoginOperatorStates;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.Tester;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;

public class LoginOperatorModelTest implements FsmModel {
        private LoginOperator sut = new LoginOperator();

        private LoginOperatorStates modelLogin = LoginOperatorStates.LOGGED_OUT;
        private boolean loggedIn = false;

        public LoginOperatorStates getState() { return modelLogin; }

        public void reset(final boolean var1) {
            if (var1) {
                sut = new LoginOperator();

            }
            modelLogin = LoginOperatorStates.LOGGED_OUT;
            loggedIn = false;
        }

        //Transitions (including guards)

    public boolean loginGuard() { return getState().equals(LoginOperatorStates.LOGGED_OUT); }
    public @Action void login() throws IOException {
            sut.validLogin();

            modelLogin = LoginOperatorStates.LOGGED_IN;
            loggedIn = true;

            Assert.assertTrue(sut.getLoggedIn());
    }

    public boolean invalidLoginGuard() {
            return getState().equals(LoginOperatorStates.LOGGED_OUT);
        }
    public @Action void invalidLogin() throws IOException {
        sut.invLogin();

        modelLogin = LoginOperatorStates.LOGGED_OUT;
        loggedIn = false;

        Assert.assertFalse(sut.getLoggedIn());
    }
    public boolean logoutGuard() { return getState().equals(LoginOperatorStates.LOGGED_IN); }
    public @Action void logout() throws IOException {
        sut.logOut();


        modelLogin = LoginOperatorStates.LOGGED_OUT;
        loggedIn = false;

        Assert.assertFalse(sut.getLoggedIn());
    }

    @Test
    public void LoginOperatorModelRunner() {
        final GreedyTester tester = new GreedyTester(new LoginOperatorModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }

}
