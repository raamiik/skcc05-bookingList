package bookRental;

import bookRental.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookingListViewHandler {


    @Autowired
    private BookingListRepository bookingListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenBooked_then_CREATE_1 (@Payload Booked booked) {
        try {
            System.out.println("여기들어오냐????");
            System.out.println("bookingID = "+booked.getBookingId());
            if (booked.isMe()) {
                System.out.println("isME 안으로 여기들어오냐????");
                // view 객체 생성
                BookingList bookingList = new BookingList();
                // view 객체에 이벤트의 Value 를 set 함
                bookingList.setBookingId(booked.getBookingId());
                bookingList.setBookName(booked.getBookName());
                bookingList.setCustomerId(booked.getCustomerId());
                bookingList.setBookingStatus(booked.getBookingStatus());
                // view 레파지 토리에 save
                bookingListRepository.save(bookingList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenUnBooked_then_UPDATE_1(@Payload UnBooked unBooked) {
        try {
            if (unBooked.isMe()) {
                // view 객체 조회
                Optional<BookingList> bookingListOptional = bookingListRepository.findByBookingId(unBooked.getBookingId());
                if( bookingListOptional.isPresent()) {
                    BookingList bookingList = bookingListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setBookingStatus(unBooked.getBookingStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenConfirmSucceeded_then_UPDATE_2(@Payload ConfirmSucceeded confirmSucceeded) {
        try {
            if (confirmSucceeded.isMe()) {
                // view 객체 조회
                Optional<BookingList> bookingListOptional = bookingListRepository.findByBookingId(confirmSucceeded.getBookingId());
                if( bookingListOptional.isPresent()) {
                    BookingList bookingList = bookingListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setCofirmStatus(confirmSucceeded.getConfirmStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenConfirmCanceled_then_UPDATE_3(@Payload ConfirmCanceled confirmCanceled) {
        try {
            if (confirmCanceled.isMe()) {
                // view 객체 조회
                Optional<BookingList> bookingListOptional = bookingListRepository.findByBookingId(confirmCanceled.getBookingId());
                if( bookingListOptional.isPresent()) {
                    BookingList bookingList = bookingListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setCofirmStatus(confirmCanceled.getConfirmStatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSaved_then_UPDATE_4(@Payload Saved saved) {
        try {
            if (saved.isMe()) {
                // view 객체 조회
                Optional<BookingList> bookingListOptional = bookingListRepository.findByBookingId(saved.getBookingId());
                if( bookingListOptional.isPresent()) {
                    BookingList bookingList = bookingListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setPointStatus(saved.getPoingstatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCanceled_then_UPDATE_5(@Payload Canceled canceled) {
        try {
            if (canceled.isMe()) {
                // view 객체 조회
                Optional<BookingList> bookingListOptional = bookingListRepository.findByBookingId(canceled.getBookingId());
                if( bookingListOptional.isPresent()) {
                    BookingList bookingList = bookingListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookingList.setPointStatus(canceled.getPoingstatus());
                    // view 레파지 토리에 save
                    bookingListRepository.save(bookingList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}