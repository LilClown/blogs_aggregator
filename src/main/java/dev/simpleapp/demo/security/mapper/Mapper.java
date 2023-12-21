package dev.simpleapp.demo.security.mapper;

public interface Mapper<D, S> {
    D map(S source);
}
