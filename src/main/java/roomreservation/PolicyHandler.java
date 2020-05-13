package roomreservation;

import roomreservation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRoomConfirmed_PayRequest(@Payload RoomConfirmed roomConfirmed){

        if(roomConfirmed.isMe()){
            System.out.println("##### listener PayRequest : " + roomConfirmed.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRoomRejected_CancelRequest(@Payload RoomRejected roomRejected){

        if(roomRejected.isMe()){
            System.out.println("##### listener CancelRequest : " + roomRejected.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_CancelRequest(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener CancelRequest : " + reservationCanceled.toJson());
        }
    }

}
