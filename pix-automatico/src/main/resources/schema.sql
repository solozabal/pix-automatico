-- Tabela de Usuários
CREATE TABLE usuarios (
    usuario_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    senha_hash VARCHAR(255) NOT NULL,
    data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    autenticacao_2f BOOLEAN DEFAULT FALSE
);

-- Tabela de Contas
CREATE TABLE contas (
    conta_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    banco VARCHAR(50) NOT NULL,
    numero_conta VARCHAR(20) NOT NULL,
    agencia VARCHAR(10) NOT NULL,
    tipo_conta ENUM('corrente', 'poupanca') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

-- Tabela de Pagamentos Recorrentes
CREATE TABLE pagamentos_recorrentes (
    pagamento_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    valor DECIMAL(10, 2) NOT NULL,
    data_vencimento DATE NOT NULL,
    frequencia ENUM('diaria', 'semanal', 'mensal') NOT NULL,
    descricao VARCHAR(255),
    status ENUM('ativo', 'cancelado') NOT NULL,
    autorizacao_previa BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

-- Tabela de Transações
CREATE TABLE transacoes (
    transacao_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    pagamento_id BIGINT,
    data_transacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    valor_transacao DECIMAL(10, 2) NOT NULL,
    status_transacao ENUM('sucesso', 'falha') NOT NULL,
    FOREIGN KEY (pagamento_id) REFERENCES pagamentos_recorrentes(pagamento_id)
);

-- Tabela de Notificações
CREATE TABLE notificacoes (
    notificacao_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    mensagem VARCHAR(255) NOT NULL,
    data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('lida', 'nao_lida') NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

-- Tabela de Logs de Atividade
CREATE TABLE logs_atividade (
    log_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    acao ENUM('criacao', 'atualizacao', 'cancelamento') NOT NULL,
    data_acao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);