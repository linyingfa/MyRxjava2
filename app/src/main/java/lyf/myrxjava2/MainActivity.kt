package lyf.myrxjava2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import org.reactivestreams.Subscriber
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

//https://www.cnblogs.com/yanyojun/p/9799907.html
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    private fun showtest() {
        val courses1 = mutableListOf<Course>()
        courses1.add(Course("1"))
        courses1.add(Course("2"))
        courses1.add(Course("3"))
        val student1 = Student()
        student1.name = "student1"
        student1.courseList = courses1
        //
        val courses2 = mutableListOf<Course>()
        courses2.add(Course("4"))
        courses2.add(Course("5"))
        courses2.add(Course("6"))
        val student2 = Student()
        student2.name = "student2"
        student2.courseList = courses2

        val students = mutableListOf<Student>()
        students.add(student1)
        students.add(student2)

        Observable.just(students)
                .subscribe(object : Observer<Student> {
                    override fun onSubscribe(d: Disposable) {}
                    override fun onNext(student: Student) {
                        for (i in 0 until student.courseList.size) {
                            println("onNext:" + student.courseList[i].name!!)
                        }
                    }

                    override fun onError(e: Throwable) {}
                    override fun onComplete() {}
                })

    }
}


