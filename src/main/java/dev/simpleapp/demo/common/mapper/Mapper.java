package dev.simpleapp.demo.common.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
