package me.simple.nm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class LazyFragment : Fragment() {

    protected var mOnViewCreated = false
    protected var mIsLayLoad = false
    protected var mIsVisibleToUser = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        init()
        return inflater.inflate(setLayoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mOnViewCreated = true

        initView()

        if (mIsVisibleToUser && !mIsLayLoad) {
            lazyLoad()
            mIsLayLoad = true
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        mIsVisibleToUser = isVisibleToUser
        if (mOnViewCreated && isVisibleToUser && !mIsLayLoad) {
            lazyLoad()
            mIsLayLoad = true
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

//    override fun onHiddenChanged(hidden: Boolean) {
//        super.onHiddenChanged(hidden)
//        LogUtils.d("hidden == $hidden")
//    }

    abstract fun setLayoutRes(): Int

    abstract fun init()

    abstract fun initView()

    abstract fun lazyLoad()
}