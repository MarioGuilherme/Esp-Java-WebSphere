package verificar;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ParOuImpar")
public class ParOuImpar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParOuImpar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int valor = Integer.parseInt(request.getParameter("number"));
		if(valor % 2 == 0 )
			out.println("O valor "+valor+" é par");
		else
			out.println("O valor "+valor+" é ímpar");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}