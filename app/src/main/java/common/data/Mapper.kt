package common.data

internal interface Mapper<SRC, DST> {
    fun transform(data: SRC): DST
}
