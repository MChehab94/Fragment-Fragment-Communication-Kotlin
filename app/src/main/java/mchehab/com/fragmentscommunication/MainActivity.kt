package mchehab.com.fragmentscommunication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.fragment_second.*

class MainActivity : AppCompatActivity(), FirstFragmentListener {

    var firstFragment = FirstFragment()
    var secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            addFragment(firstFragment, R.id.frameLayout1)
            addFragment(secondFragment, R.id.frameLayout2)
        }else{
            firstFragment = getFragment(R.id.frameLayout1) as FirstFragment
            secondFragment = getFragment(R.id.frameLayout2) as SecondFragment
        }
    }

    private fun addFragment(fragment: Fragment, layoutId: Int){
        supportFragmentManager.beginTransaction().add(layoutId, fragment).commit()
    }

    private fun getFragment(layoutId: Int): Fragment{
        return supportFragmentManager.findFragmentById(layoutId)
    }

    override fun getMessage(message: String) {
        secondFragment.textView.text = message
    }
}