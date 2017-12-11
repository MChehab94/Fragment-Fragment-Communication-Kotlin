package mchehab.com.fragmentscommunication

import kotlinx.android.synthetic.main.fragment_first.*
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class FirstFragment : Fragment() {

    var firstFragmentListener: FirstFragmentListener? = null

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSendMessage.setOnClickListener {
            firstFragmentListener?.getMessage(editText.text.toString())
        }
    }

    public override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is FirstFragmentListener) {
            firstFragmentListener= context as FirstFragmentListener?
        }
    }
}// Required empty public constructor
