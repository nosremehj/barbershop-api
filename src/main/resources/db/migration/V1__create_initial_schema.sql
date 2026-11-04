-- V1__create_initial_schema.sql
-- Migração inicial do sistema de agendamento de barbearia

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    role VARCHAR(20) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE servicos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    duracao_minutos INTEGER NOT NULL,
    ativo BOOLEAN DEFAULT TRUE
);

CREATE TABLE disponibilidades (
    id BIGSERIAL PRIMARY KEY,
    barbeiro_id BIGINT NOT NULL REFERENCES usuarios(id),
    dia_semana INTEGER NOT NULL, -- 1=Segunda, ..., 7=Domingo
    hora_inicio TIME NOT NULL,
    hora_fim TIME NOT NULL,
    hora_inicio_almoco TIME,
    hora_fim_almoco TIME
);

CREATE TABLE agendamentos (
    id BIGSERIAL PRIMARY KEY,
    cliente_id BIGINT NOT NULL REFERENCES usuarios(id),
    barbeiro_id BIGINT NOT NULL REFERENCES usuarios(id),
    servico_id BIGINT NOT NULL REFERENCES servicos(id),
    data_hora_inicio TIMESTAMP WITH TIME ZONE NOT NULL,
    data_hora_fim TIMESTAMP WITH TIME ZONE NOT NULL,
    status VARCHAR(30) NOT NULL,
    observacao VARCHAR(255),
    criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uk_barbeiro_horario UNIQUE (barbeiro_id, data_hora_inicio)
);

CREATE TABLE pagamentos (
    id BIGSERIAL PRIMARY KEY,
    agendamento_id BIGINT UNIQUE NOT NULL REFERENCES agendamentos(id),
    transacao_externa_id VARCHAR(100),
    metodo VARCHAR(30) NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,
    status VARCHAR(30) NOT NULL,
    qr_code TEXT,
    qr_code_url TEXT,
    criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    pago_em TIMESTAMP WITH TIME ZONE
);

CREATE TABLE avaliacoes (
    id BIGSERIAL PRIMARY KEY,
    agendamento_id BIGINT UNIQUE NOT NULL REFERENCES agendamentos(id),
    cliente_id BIGINT NOT NULL REFERENCES usuarios(id),
    barbeiro_id BIGINT NOT NULL REFERENCES usuarios(id),
    nota INTEGER NOT NULL CHECK (nota BETWEEN 1 AND 5),
    comentario TEXT,
    criado_em TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Índices para otimização de busca de horários e relatórios
CREATE INDEX idx_agendamentos_barbeiro_data ON agendamentos(barbeiro_id, data_hora_inicio);
CREATE INDEX idx_agendamentos_cliente ON agendamentos(cliente_id);
CREATE INDEX idx_disponibilidades_barbeiro ON disponibilidades(barbeiro_id, dia_semana);
