package bookRental;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BookingList_table")
public class BookingList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long bookingId;
        private String bookName;
        private Long customerId;
        private String bookingStatus;
        private Long confirmId;
        private String cofirmStatus;
        private Long pointId;
        private String pointStatus;


        public Long getBookingId() {
            return bookingId;
        }

        public void setBookingId(Long bookingId) {
            this.bookingId = bookingId;
        }
        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
        public String getBookingStatus() {
            return bookingStatus;
        }

        public void setBookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
        }
        public Long getConfirmId() {
            return confirmId;
        }

        public void setConfirmId(Long confirmId) {
            this.confirmId = confirmId;
        }
        public String getCofirmStatus() {
            return cofirmStatus;
        }

        public void setCofirmStatus(String cofirmStatus) {
            this.cofirmStatus = cofirmStatus;
        }
        public Long getPointId() {
            return pointId;
        }

        public void setPointId(Long pointId) {
            this.pointId = pointId;
        }
        public String getPointStatus() {
            return pointStatus;
        }

        public void setPointStatus(String pointStatus) {
            this.pointStatus = pointStatus;
        }

}
