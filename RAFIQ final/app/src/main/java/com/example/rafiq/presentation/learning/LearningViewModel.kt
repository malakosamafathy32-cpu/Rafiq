package com.example.rafiq.presentation.learning

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class LearningResource(
    val id: String,
    val title: String,
    val description: String,
    val url: String,
    val category: Category
) {
    enum class Category {
        SIGN_LANGUAGE,
        PHYSICAL_EXERCISES
    }
}

@HiltViewModel
class LearningViewModel @Inject constructor() : ViewModel() {

    private val _resources = MutableStateFlow<List<LearningResource>>(emptyList())
    val resources: StateFlow<List<LearningResource>> = _resources.asStateFlow()

    init {
        _resources.value = listOf(
            // Sign Language
            LearningResource(
                id = "sl_1",
                title = "أساسيات لغة الإشارة العربية",
                description = "تعلم الحروف والأرقام بلغة الإشارة",
                url = "https://www.youtube.com/watch?v=yP5W2H6mDbc", // Placeholder
                category = LearningResource.Category.SIGN_LANGUAGE
            ),
            LearningResource(
                id = "sl_2",
                title = "التحيات والمجاملات",
                description = "كيفية إلقاء التحية والتواصل الأساسي",
                url = "https://www.youtube.com/watch?v=yP5W2H6mDbc", // Placeholder
                category = LearningResource.Category.SIGN_LANGUAGE
            ),
            LearningResource(
                id = "sl_3",
                title = "كلمات الطوارئ والمساعدة",
                description = "كلمات مهمة للتعبير عن الحاجة للمساعدة",
                url = "https://www.youtube.com/watch?v=yP5W2H6mDbc", // Placeholder
                category = LearningResource.Category.SIGN_LANGUAGE
            ),

            // Exercises
            LearningResource(
                id = "ex_1",
                title = "تمارين تقوية الجزء العلوي",
                description = "تمارين مناسبة لمستخدمي الكراسي المتحركة",
                url = "https://www.youtube.com/watch?v=Vl035zSjXjQ", // Placeholder
                category = LearningResource.Category.PHYSICAL_EXERCISES
            ),
            LearningResource(
                id = "ex_2",
                title = "تمارين الإطالة والمرونة",
                description = "إطالات لتحسين الدورة الدموية",
                url = "https://www.youtube.com/watch?v=Vl035zSjXjQ", // Placeholder
                category = LearningResource.Category.PHYSICAL_EXERCISES
            ),
            LearningResource(
                id = "ex_3",
                title = "تمارين التنفس والاسترخاء",
                description = "تمارين بسيطة للتنفس والهدوء",
                url = "https://www.youtube.com/watch?v=Vl035zSjXjQ", // Placeholder
                category = LearningResource.Category.PHYSICAL_EXERCISES
            )
        )
    }

    fun getSignLanguageResources() = resources.value.filter { it.category == LearningResource.Category.SIGN_LANGUAGE }
    fun getExerciseResources() = resources.value.filter { it.category == LearningResource.Category.PHYSICAL_EXERCISES }
}
