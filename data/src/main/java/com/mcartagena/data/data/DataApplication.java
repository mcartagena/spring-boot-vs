package com.mcartagena.data.data;

import java.lang.annotation.Inherited;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jdk.jfr.DataAmount;

@SpringBootApplication
public class DataApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}

}

@Component
@RequiredArgsConstructor
class SampleDataInitializer{

	private final ReservationRepository reservationRepository;

	@EvnetListener(ApplicationReadyEvent.class)
	public void ready(){
		Flux<Reservation> reservations = Flux
		.just("Madhura","Marcelo","Olga","Marcin","Ria", "Stephane", "Violetta", "Dr Syer")
		.map( name -> new Reservation(null, name));
		flatMap(this.reservationRepository::save);

		// saved.subscribe();

	}

}

interface ReservationRepository extends ReactiveCrudRepository<Reservation, String>{

	Flux<Reservation> findByName(String name);
}

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
class Reservation{

	@Id
	private String id;
	private String name;

}
