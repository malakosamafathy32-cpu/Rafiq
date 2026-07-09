package com.example.rafiq.presentation.awareness

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class Hotline(
    val name: String,
    val number: String,
    val description: String
)

data class RightInfo(
    val title: String,
    val description: String
)

@HiltViewModel
class AwarenessViewModel @Inject constructor() : ViewModel() {

    private val _hotlines = MutableStateFlow<List<Hotline>>(emptyList())
    val hotlines: StateFlow<List<Hotline>> = _hotlines.asStateFlow()

    private val _rights = MutableStateFlow<List<RightInfo>>(emptyList())
    val rights: StateFlow<List<RightInfo>> = _rights.asStateFlow()

    init {
        _hotlines.value = listOf(
            Hotline(
                name = "المجلس القومي للأشخاص ذوي الإعاقة",
                number = "15044",
                description = "للشكاوى والاستفسارات المتعلقة بحقوق ذوي الإعاقة"
            ),
            Hotline(
                name = "خط نجدة حقوق الإنسان",
                number = "15508",
                description = "للإبلاغ عن أي انتهاكات أو تعرض للأذى"
            ),
            Hotline(
                name = "الإسعاف للطوارئ",
                number = "123",
                description = "للحالات الطبية الطارئة"
            )
        )

        _rights.value = listOf(
            RightInfo(
                title = "الحق في التوظيف",
                description = "يُلزم القانون أصحاب العمل الذين يستخدمون 20 عاملًا فأكثر بتعيين نسبة 5% من عدد العاملين من الأشخاص ذوي الإعاقة."
            ),
            RightInfo(
                title = "الحق في التعليم",
                description = "ضمان حق الأشخاص ذوي الإعاقة في التعليم الدامج بجميع مراحل التعليم وتوفير الترتيبات التيسيرية."
            ),
            RightInfo(
                title = "الحق في الإتاحة",
                description = "الالتزام بتوفير الترتيبات التيسيرية في المنشآت والمرافق العامة ووسائل النقل لتسهيل استخدامها."
            ),
            RightInfo(
                title = "الإعفاءات الضريبية والجمركية",
                description = "إعفاء السيارات ووسائل النقل الفردية المعدة لاستخدام الأشخاص ذوي الإعاقة من الضريبة الجمركية وضريبة القيمة المضافة."
            )
        )
    }
}
