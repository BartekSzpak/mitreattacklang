import org.junit.Test;

import core.*;
import jdk.internal.jline.internal.TestAccessible;
import attack.*;

public class userExecutionTest{

        @Test
        public void test1() {
            Computer computer = new Computer("computer");
            Os os = new Os ("os", true);
            Employee employee = new Employee ("employee");

            computer.addOs(os);
            computer.addEmployee(employee);

            employee.addComputer(computer);

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(employee.userExecution);
            attacker.attack();

            computer.infectedComputer.assertUncompromised();
        }

        public void test2() {
            Computer computer = new Computer("computer");
            Os os = new Os ("os", false);
            Employee employee = new Employee ("employee");

            computer.addOs(os);
            computer.addEmployee(employee);

            employee.addComputer(computer);

            Attacker attacker = new Attacker();
            attacker.addAttackPoint(employee.userExecution);
            attacker.attack();

            computer.infectedComputer.assertCompromisedInstantaneously();
        }

}
