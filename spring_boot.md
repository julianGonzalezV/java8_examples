//Notas 

Anotaciones:
@RestController: Indica que la clase es un controlador Web y por lo tanto atenderá las peticiones (requests
@RequestMapping : Se encarga del routing, dado una peticion entonces que método deberá ejecutar

@EnableAutoConfiguration: Carga la configuracion basada en las dependencias especificadas

@SpringBootApplication: This annotation is equivalent to using @Configuration, @EnableAutoConfiguration and @ComponentScan
es la anotacion que se coloca en la clase inicial eg

 public static void main(String[] args) {
        SpringApplication.run(MyApp01.class, args);
    }




Iniciar la aplicacion:
Configurar la tarea gradle y 
./gradlew bootRun: Me pareció que éste es m+as liviano

gradle booRun: Parece que acá desacar todo y genera el jar 


13.5 Starters::::::::::::::
