package roomreservation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String reserveId;
    private String status;

    @PostPersist
    public void onPostPersist(){
        PayCompleted payCompleted = new PayCompleted();
        BeanUtils.copyProperties(this, payCompleted);
        payCompleted.publishAfterCommit();


        PayFailed payFailed = new PayFailed();
        BeanUtils.copyProperties(this, payFailed);
        payFailed.publishAfterCommit();


        PayCanceled payCanceled = new PayCanceled();
        BeanUtils.copyProperties(this, payCanceled);
        payCanceled.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}
