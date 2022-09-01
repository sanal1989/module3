package filter;

import org.junit.jupiter.api.Test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class GameFilterTest {

    private final static String PATH = "/WEB-INF/index.jsp";

    @Test
    public void whenDoGet() throws ServletException, IOException {
        GameFilter filter = mock(GameFilter.class);
        ServletRequest servletRequest = mock(ServletRequest.class);
        ServletResponse servletResponse = mock(ServletResponse.class);
        FilterChain filterChain = mock(FilterChain.class);

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse res = mock(HttpServletResponse.class);



        filter.doFilter(servletRequest,servletResponse,filterChain);

        verify(res,never()).sendRedirect(PATH);
        verify(req,never()).getCookies();

    }
}
