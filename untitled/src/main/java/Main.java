import com.sudoku.config.AppConfig;
import com.sudoku.controler.SudokuController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        SudokuController controller = context.getBean("sudokuController", SudokuController.class);
        //controller.solveSudoku();
    }
}
