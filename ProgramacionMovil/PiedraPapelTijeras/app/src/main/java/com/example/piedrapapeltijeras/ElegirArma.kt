package com.example.piedrapapeltijeras

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ElegirArma.newInstance] factory method to
 * create an instance of this fragment.
 */
class ElegirArma : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: Comunicador?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elegir_arma, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is Comunicador) {
            listener = context
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val buttonPiedra = view.findViewById<ImageButton>(R.id.imgBtnPiedra)
        val buttonPapel = view.findViewById<ImageButton>(R.id.imgBtnPapel)
        val buttonTijeras = view.findViewById<ImageButton>(R.id.imgBtnTijeras)
        buttonPiedra.setOnClickListener{
            listener?.onClickImgBtnPiedra()
        }
        buttonPapel.setOnClickListener{
            listener?.onClickImgBtnPapel()
        }
        buttonTijeras.setOnClickListener{
            listener?.onClickImgBtnTijeras()
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ElegirArma.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ElegirArma().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}