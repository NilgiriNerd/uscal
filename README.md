# USCAL
##Unified Side-Cache for Application Layer

Spring Cache Abstraction provides an easy way to implement side caches within applications. However, when using distributed Caching solutions such as Gemfire/Geode as the backing infrastructure, it is required to setup individual Regions for each use case to avoid Key Conflicts. This adds to the setup required.

USCAL provides a Customized Spring Cache Abstraction CacheManager that facilitates utilizing a global Side Cache Region across multiple applications. It appends key prefixes to avoid key conflicts and hence removes the need to create regions specific to each usecase.