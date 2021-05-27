package com.kotlin.animationtest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.animationtest.MainActivity
import com.kotlin.animationtest.R
import com.kotlin.animationtest.ui.activity.FrameAnimationAcy
import com.kotlin.animationtest.ui.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.startActivity
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var mAdapter: HomeAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        val data = listOf<String>("帧动画")
        mAdapter.addData(data)
    }

    private fun initView() {
        mAdapter = HomeAdapter()
        mAdapter.setOnItemClickListener { adapter, view, position ->
            if(position == 0){          //动画
                context?.startActivity<FrameAnimationAcy>()
            }
        }
        mHomeRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = mAdapter
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }

    }
}