package kotlinInAction.ch4.constructor

import android.content.Context
import android.util.AttributeSet

open class View {
    constructor(ctx: Context) {
        println("context!")
    }

    constructor(ctx: Context, attr: AttributeSet?) {
        println("attributeSet!!")
    }
}

class MyButton : View {
    constructor(ctx: Context) : this(ctx, null){
        // ...
    }
    constructor(ctx: Context, attr: AttributeSet?) : super(ctx, attr){
        // ...
    }
}