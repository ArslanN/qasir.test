package qasir.test.com;

import io.reactivex.Observable;
import qasir.test.com.pojo.Pojo;
import retrofit2.http.GET;

/**
 * Created by Asad.
 */
public interface Api {


    @GET("bins/gsq5w")
    Observable<Pojo> getJson();


}
