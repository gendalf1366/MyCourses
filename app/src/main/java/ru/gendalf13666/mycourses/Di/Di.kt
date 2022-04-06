package ru.gendalf13666.mycourses.Di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.gendalf13666.mycourses.Data.Repository.RepositoryImpl
import ru.gendalf13666.mycourses.Data.Repository.datasource.DataSource
import ru.gendalf13666.mycourses.Data.Repository.datasource.MockDataSourceImpl
import ru.gendalf13666.mycourses.Domain.Repository.Repository
import ru.gendalf13666.mycourses.Domain.Usecases.GetExamUseCase
import ru.gendalf13666.mycourses.Domain.Usecases.GetHomeWorkUseCase
import ru.gendalf13666.mycourses.Domain.Usecases.GetLessonUseCase
import ru.gendalf13666.mycourses.Ui.Classes.ClassesViewModel
import ru.gendalf13666.mycourses.Ui.Favourite.FavouriteViewModel
import ru.gendalf13666.mycourses.Ui.Home.HomeViewModel
import ru.gendalf13666.mycourses.Ui.List.ListViewModel

object Di {

    fun viewModelModule() = module {
        viewModel() {
            ClassesViewModel(
                getLessonUseCase = get()
            )
        }

        viewModel() {
            FavouriteViewModel()
        }

        viewModel() {
            HomeViewModel(
                getLessonUseCase = get(),
                getHomeWorkUseCase = get(),
                getExamUseCase = get()
            )
        }

        viewModel() {
            ListViewModel()
        }
    }

    fun useCasesModule() = module {
        factory {
            GetLessonUseCase(repository = get())
        }
        factory {
            GetHomeWorkUseCase(repository = get())
        }
        factory {
            GetExamUseCase(repository = get())
        }
    }

    fun repositoryModule() = module {
        single<Repository>() {
            RepositoryImpl(
                dataSource = get()
            )
        }

        single<DataSource> {
            MockDataSourceImpl()
        }
    }
}
