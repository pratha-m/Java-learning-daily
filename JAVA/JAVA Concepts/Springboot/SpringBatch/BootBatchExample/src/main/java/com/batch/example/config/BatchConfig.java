package com.batch.example.config;

import com.batch.example.model.Product;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfig {

    @Bean
    public Job jobBean(
            JobRepository jobRepository,
            JobCompletionNotificationImpl listener,
            Step steps
    ){
        return new JobBuilder("job",jobRepository)
                .listener(listener)
                .start(steps)
                .build();
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public Step steps(
        JobRepository jobRepository,
        DataSourceTransactionManager transactionManager,
        ItemReader<Product> reader,
        ItemProcessor<Product,Product> processor,
        ItemWriter<Product> writer
    ){
        return new StepBuilder("jobStep",jobRepository)
                .<Product,Product>chunk(5,transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .taskExecutor(taskExecutor())
                .build();
    }

    @Bean
    public FlatFileItemReader<Product> reader(){
        return new FlatFileItemReaderBuilder<Product>()
                .name("itemReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names("productId","title","description","price","discount")
                .targetType(Product.class)
                .build();
    }

    @Bean
    public ItemProcessor<Product,Product> itemProcessor(){
        return new CustomItemProcessor();
    }

    @Bean
    public ItemWriter<Product> itemWriter(DataSource dataSource){
        return new JdbcBatchItemWriterBuilder<Product>()
                .sql("insert into products(product_id,title,description,price,discount,discounted_price) values(:productId,:title,:description,:price,:discount,:discounted_price)")
                .dataSource(dataSource)
                .beanMapped()
                .build();
    }

    @Bean
    public TaskExecutor taskExecutor(){
        SimpleAsyncTaskExecutor taskExecutor=new SimpleAsyncTaskExecutor();
        taskExecutor.setConcurrencyLimit(5);
        return taskExecutor;
    }


}
