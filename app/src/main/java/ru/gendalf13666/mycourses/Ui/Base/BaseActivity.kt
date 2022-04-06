package ru.gendalf13666.mycourses.Ui.Base

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gendalf13666.mycourses.R
import ru.gendalf13666.mycourses.databinding.ActivityMainBinding

abstract class BaseActivity(@LayoutRes contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    protected val viewBinding: ActivityMainBinding by viewBinding()
    private val srcIn = PorterDuff.Mode.SRC_IN

    protected fun initClickListener() {
        with(viewBinding) {
            bottomNavigation.home.setOnClickListener {
                setHomeActiveTitle()
                setHomeActiveBackgroundColor()
                setHomeActiveIconColor()
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.navigation_home)
            }

            bottomNavigation.classes.setOnClickListener {
                setClassesActiveTitle()
                setClassesActiveBackgroundColor()
                setClassesActiveIconColor()
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.navigation_classes)
            }

            bottomNavigation.list.setOnClickListener {
                setListActiveTitle()
                setListActiveBackgroundColor()
                setListActiveIconColor()
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.navigation_list)
            }

            bottomNavigation.favourite.setOnClickListener {
                setFavouriteActiveTitle()
                setFavouriteActiveBackgroundColor()
                setFavouriteActiveIconColor()
                findNavController(R.id.nav_host_fragment_activity_main)
                    .navigate(R.id.navigation_favourite)
            }
        }
    }

    private fun ActivityMainBinding.setFavouriteActiveIconColor() {
        with(bottomNavigation) {
            homeIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            classesIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            listIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            favouriteIcon.setColorFilter(Color.parseColor(ITEM_ICON_ACTIVE_COLOR), srcIn)
        }
    }

    private fun ActivityMainBinding.setListActiveIconColor() {
        with(bottomNavigation) {
            homeIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            classesIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            listIcon.setColorFilter(Color.parseColor(ITEM_ICON_ACTIVE_COLOR), srcIn)
            favouriteIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
        }
    }

    private fun ActivityMainBinding.setClassesActiveIconColor() {
        with(bottomNavigation) {
            homeIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            classesIcon.setColorFilter(Color.parseColor(ITEM_ICON_ACTIVE_COLOR), srcIn)
            listIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            favouriteIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
        }
    }

    private fun ActivityMainBinding.setHomeActiveIconColor() {
        with(bottomNavigation) {
            homeIcon.setColorFilter(Color.parseColor(ITEM_ICON_ACTIVE_COLOR), srcIn)
            classesIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            listIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
            favouriteIcon.setColorFilter(Color.parseColor(ITEM_ICON_NO_ACTIVE_COLOR), srcIn)
        }
    }

    private fun ActivityMainBinding.setFavouriteActiveBackgroundColor() {
        with(bottomNavigation) {
            home.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            classes.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            list.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            favourite.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_ACTIVE_COLOR))
        }
    }

    private fun ActivityMainBinding.setListActiveBackgroundColor() {
        with(bottomNavigation) {
            home.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            classes.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            list.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_ACTIVE_COLOR))
            favourite.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
        }
    }

    private fun ActivityMainBinding.setClassesActiveBackgroundColor() {
        with(bottomNavigation) {
            home.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            classes.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_ACTIVE_COLOR))
            list.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            favourite.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
        }
    }

    private fun ActivityMainBinding.setHomeActiveBackgroundColor() {
        with(bottomNavigation) {
            home.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_ACTIVE_COLOR))
            classes.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            list.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
            favourite.setCardBackgroundColor(Color.parseColor(ITEM_BACKGROUND_IN_ACTIVE_COLOR))
        }
    }

    private fun ActivityMainBinding.setFavouriteActiveTitle() {
        with(bottomNavigation) {
            homeTitle.text = EMPTY_STRING
            classesTitle.text = EMPTY_STRING
            favouriteTitle.text = BOTTOM_ITEM_TEXT_FAVOURITE
            listTitle.text = EMPTY_STRING
        }
    }

    private fun ActivityMainBinding.setListActiveTitle() {
        with(bottomNavigation) {
            homeTitle.text = EMPTY_STRING
            classesTitle.text = EMPTY_STRING
            favouriteTitle.text = EMPTY_STRING
            listTitle.text = BOTTOM_ITEM_TEXT_LIST
        }
    }

    private fun ActivityMainBinding.setClassesActiveTitle() {
        with(bottomNavigation) {
            homeTitle.text = EMPTY_STRING
            listTitle.text = EMPTY_STRING
            favouriteTitle.text = EMPTY_STRING
            classesTitle.text = BOTTOM_ITEM_TEXT_CLASSES
        }
    }

    private fun ActivityMainBinding.setHomeActiveTitle() {
        with(bottomNavigation) {
            homeTitle.text = BOTTOM_ITEM_TEXT_HOME
            listTitle.text = EMPTY_STRING
            favouriteTitle.text = EMPTY_STRING
            classesTitle.text = EMPTY_STRING
        }
    }

    companion object {
        private const val BOTTOM_ITEM_TEXT_HOME = "Home"
        private const val BOTTOM_ITEM_TEXT_CLASSES = "Classes"
        private const val BOTTOM_ITEM_TEXT_LIST = "List"
        private const val BOTTOM_ITEM_TEXT_FAVOURITE = "Fav"
        private const val EMPTY_STRING = ""
        private const val ITEM_ICON_NO_ACTIVE_COLOR = "#FFFFFF"
        private const val ITEM_ICON_ACTIVE_COLOR = "#2dc692"
        private const val ITEM_BACKGROUND_ACTIVE_COLOR = "#223836"
        private const val ITEM_BACKGROUND_IN_ACTIVE_COLOR = "#24252a"
    }
}
