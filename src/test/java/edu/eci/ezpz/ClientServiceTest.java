package edu.eci.ezpz;

import edu.eci.ezpz.repository.ClientRepository;
import edu.eci.ezpz.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest
@TestInstance( TestInstance.Lifecycle.PER_CLASS )
public class ClientServiceTest {

    @InjectMocks
    ClientServiceImpl service;

    @MockBean
    ClientRepository repository ;


}
